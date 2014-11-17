package kaitou.exercise.oauth2.consumer.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 模拟用户请求.
 * User: 赵立伟
 * Date: 2014/5/29
 * Time: 14:41
 */
public class MockUserRequestAction extends ActionSupport {

    private String appKey = "appKey1";
    private String appSecret = "appSecret1";
    private String access_token;

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

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String request1() {
        return SUCCESS;
    }

    public String request2() {
        return SUCCESS;
    }
}
