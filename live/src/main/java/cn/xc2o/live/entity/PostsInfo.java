package cn.xc2o.live.entity;

/**
 *
 * Created by cc on 2017/7/3.
 */
public class PostsInfo extends LongId {
    /* 所属组 */
    private Long groupId;
    /* 普通贴 */
    private Integer type = 0;
    /* 标题 */
    private String title;
    /* 内容 */
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
