package cn.xc2o.live.vo;

import org.springframework.data.domain.Page;

/**
 *
 * Created by cc on 2017/7/3.
 */
public class PostsDetailVo {
    private Long groupId;
    private Long postsId;
    private String title;
    private Page<PostsReplyVo> reply;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getPostsId() {
        return postsId;
    }

    public void setPostsId(Long postsId) {
        this.postsId = postsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Page<PostsReplyVo> getReply() {
        return reply;
    }

    public void setReply(Page<PostsReplyVo> reply) {
        this.reply = reply;
    }
}
