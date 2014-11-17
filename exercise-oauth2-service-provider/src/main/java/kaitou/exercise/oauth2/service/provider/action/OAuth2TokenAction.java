package kaitou.exercise.oauth2.service.provider.action;

import com.opensymphony.xwork2.ActionSupport;
import kaitou.exercise.oauth2.service.provider.service.OAuth2TokenService;

/**
 * 服务提供方之token服务.
 * User: 赵立伟
 * Date: 2014/5/29
 * Time: 9:54
 */
public class OAuth2TokenAction extends ActionSupport {

    private OAuth2TokenService oAuth2TokenService;
    private String appKey;
    private String appSecret;
    private String unauthorizedRequestToken;
    private String authorizedRequestToken;
    private String accessToken;
    private String error;

    public void setoAuth2TokenService(OAuth2TokenService oAuth2TokenService) {
        this.oAuth2TokenService = oAuth2TokenService;
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

    public String getAuthorizedRequestToken() {
        return authorizedRequestToken;
    }

    public void setAuthorizedRequestToken(String authorizedRequestToken) {
        this.authorizedRequestToken = authorizedRequestToken;
    }

    public String getUnauthorizedRequestToken() {
        return unauthorizedRequestToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getError() {
        return error;
    }

    public String authorization() {
        unauthorizedRequestToken = oAuth2TokenService.getUnauthorizedRequestToken(appKey, appSecret);
        return SUCCESS;
    }

    public String success() {
        accessToken = oAuth2TokenService.getAccessToken(appKey, appSecret, authorizedRequestToken);
        return SUCCESS;
    }

    public String accessFailed() {
        error = "No permission.";
        return ERROR;
    }
}
