package cn.xc2o.live.assemble;

import cn.xc2o.live.dto.PostsCreateReq;
import cn.xc2o.live.entity.PostsInfo;
import cn.xc2o.live.entity.PostsReply;
import cn.xc2o.live.entity.UserInfo;
import cn.xc2o.live.utils.DateUtils;
import cn.xc2o.live.vo.PostsReplyVo;
import cn.xco2o.common.utils.SampleIdUtils;

import java.util.Date;

/**
 * Created by cc on 2017/7/5.
 */
public class ReplyAssemble {

    public static PostsReply fromCreateReq(Long userId, Long groupId, Long postsId, PostsCreateReq req) {
        PostsReply postsReply = new PostsReply();
        postsReply.setId(SampleIdUtils.gen());
        postsReply.setPostsId(postsId);
        postsReply.setContent(req.getContent());
        postsReply.setCreateBy(userId);
        postsReply.setCreateTime(System.currentTimeMillis());
        return postsReply;
    }

    public static PostsReplyVo entityToVo(PostsInfo postsInfo, UserInfo userInfo , PostsReply postsReply){
        PostsReplyVo replyVo = new PostsReplyVo();
        replyVo.setType(postsInfo.getType());
        replyVo.setContent(postsReply.getContent());
        replyVo.setFloor(postsReply.getFloor());
        replyVo.setTime(DateUtils.frindlyTime(postsReply.getCreateTime()));
        replyVo.setUser(UserAssemble.baseInfo(userInfo));
        return replyVo;
    }
}
