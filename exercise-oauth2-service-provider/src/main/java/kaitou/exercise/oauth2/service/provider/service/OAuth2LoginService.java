package kaitou.exercise.oauth2.service.provider.service;

import kaitou.exercise.oauth2.common.dto.LoginDTO;

/**
 * 服务提供方登录验证.
 * User: 赵立伟
 * Date: 2014/5/29
 * Time: 13:45
 */
public interface OAuth2LoginService {

    /**
     * 用户OAuth2登录验证
     *
     * @param loginDTO 登录验证信息
     * @return 用户授权的Request Token
     */
    public String oauth2Login(LoginDTO loginDTO);
}
