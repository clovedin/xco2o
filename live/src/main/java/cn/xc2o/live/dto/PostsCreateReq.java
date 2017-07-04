package cn.xc2o.live.dto;

/**
 * Created by cc on 2017/7/3.
 */
public class PostsCreateReq {
    private Integer type;
    private String title;
    private String content;

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
