package cn.xc2o.live.entity;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * 消息的基本组织单位
 * Created by cc on 2017/7/3.
 */
public class GroupInfo extends LongId {
    /* 组类型 */
    @QuerySqlField
    private Integer type;
    /* 所属 */
    @QuerySqlField
    private Long parent;
    /* 组名 */
    @QuerySqlField
    private String name;
    /* logo */
    private String logo;
    /* 描述 */
    private String desc;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
