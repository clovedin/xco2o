package cn.xc2o.live.service;

import cn.xc2o.live.assemble.PostsAssemble;
import cn.xc2o.live.assemble.ReplyAssemble;
import cn.xc2o.live.assemble.UserAssemble;
import cn.xc2o.live.common.ResultConstant;
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
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        PostsReply postsReply = ReplyAssemble.fromCreateReq(userId, groupId, postsInfo.getId(), req);
        postsReply = postsReplyRepository.save(postsReply.getId(), postsReply);
        PostsCreateRsp response = PostsAssemble.toCreateRsp(postsInfo);
        result.setData(response);
        return result;
    }

    @Override
    public Result<PostsDetailVo> detail(Long group, Long id, org.springframework.data.domain.Pageable pageable) {
        Result<PostsDetailVo> result = new Result<>();
        PostsInfo postsInfo = postsInfoRepository.findOne(id);
        if (null == postsInfo){
            result.setError(ResultConstant.NotFind);
            return result;
        }
        List<PostsReplyVo> replyVos = null;
        Long total = postsReplyRepository.countByPostsId(postsInfo.getId());
        if (total > 0){
            replyVos = new ArrayList<>();
            List<PostsReply> replys = postsReplyRepository.findByPostsId(postsInfo.getId(), pageable);
            replyVos = replys.stream().map(reply -> {
                UserInfo userInfo = userInfoRepository.findOne(reply.getCreateBy());
                return ReplyAssemble.entityToVo(postsInfo, userInfo, reply);
            }).collect(Collectors.toList());
        }
        Page<PostsReplyVo> replyPage = new PageImpl<>(replyVos, pageable, total);
        PostsDetailVo data = PostsAssemble.detailVo(postsInfo, replyPage);
        result.setData(data);
        return result;
    }
}
