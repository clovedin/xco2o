package cn.xc2o.live.entity;

/**
 * 消息组成员
 * Created by cc on 2017/7/3.
 */
public class GroupMember {
    /* 组id */
    private Long groupId;
    /* 成员id */
    private Long memberId;
    /* 组内等级 */
    private Integer level;
    /* 组内昵称 */
    private String alias;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
