package com.sjht.school.football.req.sys;

import java.io.Serializable;

/**
 * ***************************************************
 *
 * @ClassName UpdateUserReq
 * @Description 用户更新密码请求
 * @Author 张弛
 * @Date 2019/9/23 15:45
 * @Version V1.0
 * ****************************************************
 **/
public class UpdateUserReq implements Serializable {
    private String userId;
    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }
}
