package cn.xc2o.live.vo;

/**
 * Created by cc on 2017/7/3.
 */
public class PostsReplyVo {
    private String content;
    private Integer floor;
    private String time;
    private UserBaseVo user;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public UserBaseVo getUser() {
        return user;
    }

    public void setUser(UserBaseVo user) {
        this.user = user;
    }
}
