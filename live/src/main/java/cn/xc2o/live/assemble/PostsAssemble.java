package cn.xc2o.live.assemble;

import cn.xc2o.live.common.LiveConstant;
import cn.xc2o.live.dto.PostsCreateReq;
import cn.xc2o.live.dto.PostsCreateRsp;
import cn.xc2o.live.entity.PostsInfo;
import cn.xc2o.live.entity.PostsReply;
import cn.xc2o.live.entity.UserInfo;
import cn.xc2o.live.vo.PostsDetailVo;
import cn.xc2o.live.vo.PostsReplyVo;
import cn.xco2o.common.utils.SampleIdUtils;
import org.springframework.data.domain.Page;

import java.util.Date;

/**
 * Created by cc on 2017/7/4.
 */
public class PostsAssemble {

    public static PostsInfo fromCreateReq(Long userId, Long groupId, PostsCreateReq req) {
        PostsInfo postsInfo = new PostsInfo();
        postsInfo.setId(SampleIdUtils.gen());
        postsInfo.setGroupId(groupId);
        postsInfo.setType(LiveConstant.PostType_Normal);
        postsInfo.setTitle(req.getTitle());
        postsInfo.setCreateBy(userId);
        postsInfo.setCreateTime(System.currentTimeMillis());
        return postsInfo;
    }

    public static PostsCreateRsp toCreateRsp(PostsInfo postsInfo) {
        PostsCreateRsp response = new PostsCreateRsp();
        response.setId(postsInfo.getId());
        return response;
    }

    public static PostsDetailVo detailVo(PostsInfo postsInfo, Page<PostsReplyVo> replyVos) {
        PostsDetailVo detailVo = new PostsDetailVo();
        detailVo.setPostsId(postsInfo.getId());
        detailVo.setGroupId(postsInfo.getGroupId());
        detailVo.setTitle(postsInfo.getTitle());
        detailVo.setReply(replyVos);
        return detailVo;
    }
}
