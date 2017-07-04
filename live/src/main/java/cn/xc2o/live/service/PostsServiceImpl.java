package cn.xc2o.live.service;

import cn.xc2o.live.assemble.PostsAssemble;
import cn.xc2o.live.assemble.UserAssemble;
import cn.xc2o.live.dao.PostsInfoRepository;
import cn.xc2o.live.dao.PostsReplyRepository;
import cn.xc2o.live.dao.UserInfoRepository;
import cn.xc2o.live.dto.PostsCreateReq;
import cn.xc2o.live.dto.PostsCreateRsp;
import cn.xc2o.live.entity.PostsInfo;
import cn.xc2o.live.common.Result;
import cn.xc2o.live.entity.PostsReply;
import cn.xc2o.live.entity.UserInfo;
import cn.xc2o.live.utils.DateUtils;
import cn.xc2o.live.vo.PostsDetailVo;
import cn.xc2o.live.vo.PostsReplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.awt.print.Pageable;

/**
 * Created by cc on 2017/7/4.
 */
@Component
public class PostsServiceImpl implements PostsService {

    @Autowired
    private PostsInfoRepository postsInfoRepository;
    @Autowired
    private PostsReplyRepository postsReplyRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public Result<PostsCreateRsp> posts(Long userId, Long groupId, PostsCreateReq req) {
        Result<PostsCreateRsp> result = new Result<>();
        PostsInfo postsInfo = PostsAssemble.fromCreateReq(userId, groupId, req);
        postsInfo = postsInfoRepository.save(postsInfo.getId(), postsInfo);
        PostsCreateRsp response = PostsAssemble.toCreateRsp(postsInfo);
        result.setData(response);
        return result;
    }

    @Override
    public Result<PostsDetailVo> detail(Long group, Long id, org.springframework.data.domain.Pageable pageable) {
        Result<PostsDetailVo> result = new Result<>();
        PostsInfo postsInfo = postsInfoRepository.findOne(id);
        Page<PostsReply> replyPage = postsReplyRepository.findByPostsId(postsInfo.getId(), pageable);
        Page<PostsReplyVo> replyVos = replyPage.map(reply -> {
            PostsReplyVo replyVo = new PostsReplyVo();
            UserInfo userInfo = userInfoRepository.findOne(reply.getCreateBy());
            replyVo.setContent(reply.getContent());
            replyVo.setFloor(reply.getFloor());
            replyVo.setTime(DateUtils.frindlyTime(reply.getCreateTime()));
            replyVo.setUser(UserAssemble.baseInfo(userInfo));
            return replyVo;
        });
        PostsDetailVo data = PostsAssemble.detailVo(postsInfo, replyVos);
        result.setData(data);
        return result;
    }
}
