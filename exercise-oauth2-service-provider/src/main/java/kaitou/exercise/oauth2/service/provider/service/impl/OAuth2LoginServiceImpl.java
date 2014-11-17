package kaitou.exercise.oauth2.service.provider.service.impl;

import kaitou.exercise.oauth2.common.OAuth2Exception;
import kaitou.exercise.oauth2.common.dto.LoginDTO;
import kaitou.exercise.oauth2.service.provider.service.OAuth2LoginService;
import kaitou.exercise.oauth2.service.provider.service.OAuth2TokenService;

/**
 * Created with IntelliJ IDEA.
 * User: 赵立伟
 * Date: 2014/5/29
 * Time: 13:48
 */
public class OAuth2LoginServiceImpl implements OAuth2LoginService {

    private OAuth2TokenService oAuth2TokenService;

    public void setoAuth2TokenService(OAuth2TokenService oAuth2TokenService) {
        this.oAuth2TokenService = oAuth2TokenService;
    }

    @Override
    public String oauth2Login(LoginDTO loginDTO) {
        if (!"user".equalsIgnoreCase(loginDTO.getLoginName()) || !"123456".equalsIgnoreCase(loginDTO.getPassword())) {
            throw new OAuth2Exception("Invalid loginName or password.");
        }
        return oAuth2TokenService.getAuthorizedRequestToken(loginDTO.getAppKey(), loginDTO.getAppSecret(), loginDTO.getUnauthorizedRequestToken());
    }
}
