package cn.xc2o.live.entity;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * Created by cc on 2017/7/4.
 */
public class UserInfo extends LongId {
    @QuerySqlField
    private String name;
    @QuerySqlField
    private Integer age;
    private Integer sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
