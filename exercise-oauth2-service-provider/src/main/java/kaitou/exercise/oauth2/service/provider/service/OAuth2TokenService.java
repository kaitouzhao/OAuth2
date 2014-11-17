package kaitou.exercise.oauth2.service.provider.service;

/**
 * token服务.
 * User: 赵立伟
 * Date: 2014/5/29
 * Time: 10:11
 */
public interface OAuth2TokenService {

    /**
     * 获取未授权的Request Token
     *
     * @param appKey    应用key
     * @param appSecret 应用秘钥
     * @return 未授权的Request Token
     */
    public String getUnauthorizedRequestToken(String appKey, String appSecret);

    /**
     * 获取用户授权的Request Token
     *
     * @param appKey                   应用key
     * @param appSecret                应用秘钥
     * @param unauthorizedRequestToken 未授权的Request Token
     * @return 用户授权的Request Token
     */
    public String getAuthorizedRequestToken(String appKey, String appSecret, String unauthorizedRequestToken);

    /**
     * 使用授权的Request Token换取Access Token
     *
     * @param appKey                 应用key
     * @param appSecret              应用秘钥
     * @param authorizedRequestToken 用户授权的Request Token
     * @return Access Token
     */
    public String getAccessToken(String appKey, String appSecret, String authorizedRequestToken);
}
