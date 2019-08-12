package com.zq.retrofitdemo.bean;

/**
 * Created by zhangqi on 2019/6/27
 */
public class GetDeductReq {
    private String schoolId;

    private String stu_token;

    private String user_id;

    public GetDeductReq(String schoolId, String stu_token, String user_id) {
        this.schoolId = schoolId;
        this.stu_token = stu_token;
        this.user_id = user_id;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolId() {
        return this.schoolId;
    }

    public void setStu_token(String stu_token) {
        this.stu_token = stu_token;
    }

    public String getStu_token() {
        return this.stu_token;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_id() {
        return this.user_id;
    }
}
