package cn.xc2o.live.entity;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Created by cc on 2017/7/3.
 */
public class PostsReply extends LongId {
    @QuerySqlField
    private Long postsId;
    /* 内容 */
    private String content;
    /* 楼层 */
    private Integer floor = 0;

    public Long getPostsId() {
        return postsId;
    }

    public void setPostsId(Long postsId) {
        this.postsId = postsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }
}
