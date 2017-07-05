package cn.xc2o.live.entity;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 *
 * Created by cc on 2017/7/3.
 */
public class PostsInfo extends LongId {
    /* 所属组 */
    @QuerySqlField
    private Long groupId;
    /* 普通贴 */
    @QuerySqlField
    private Integer type = 0;
    /* 标题 */
    @QuerySqlField
    private String title;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
