package cn.xc2o.live.entity;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;

/**
 * Created by cc on 2017/7/4.
 */
public class LongId implements Serializable {
    /* 主键 */
    @QuerySqlField(index = true)
    private Long id;
    /* 创建人 */
    @QuerySqlField
    private Long createBy;
    /* 创建时间 */
    @QuerySqlField
    private Long createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
