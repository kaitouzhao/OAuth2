package kaitou.exercise.oauth2.common.dto;

/**
 * 登录验证.
 * User: 赵立伟
 * Date: 2014/5/29
 * Time: 13:44
 */
public class LoginDTO {

    private String loginName;
    private String password;
    private String unauthorizedRequestToken;
    private String appKey;
    private String appSecret;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUnauthorizedRequestToken() {
        return unauthorizedRequestToken;
    }

    public void setUnauthorizedRequestToken(String unauthorizedRequestToken) {
        this.unauthorizedRequestToken = unauthorizedRequestToken;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}
