package kaitou.exercise.oauth2.service.provider.action;

import com.opensymphony.xwork2.ActionSupport;
import kaitou.exercise.oauth2.common.dto.LoginDTO;
import kaitou.exercise.oauth2.service.provider.service.OAuth2LoginService;

/**
 * 服务方用户登录.
 * User: 赵立伟
 * Date: 2014/5/29
 * Time: 13:55
 */
public class OAuth2LoginAction extends ActionSupport {

    private OAuth2LoginService oAuth2LoginService;
    private LoginDTO loginDTO;
    private String authorizedRequestToken;

    public void setoAuth2LoginService(OAuth2LoginService oAuth2LoginService) {
        this.oAuth2LoginService = oAuth2LoginService;
    }

    public LoginDTO getLoginDTO() {
        return loginDTO;
    }

    public void setLoginDTO(LoginDTO loginDTO) {
        this.loginDTO = loginDTO;
    }

    public String getAuthorizedRequestToken() {
        return authorizedRequestToken;
    }

    public String oauth2Login() {
        authorizedRequestToken = oAuth2LoginService.oauth2Login(loginDTO);
        return SUCCESS;
    }
}
