package kaitou.exercise.oauth2.dao;

/**
 * Token数据服务.
 * User: 赵立伟
 * Date: 2014/5/29
 * Time: 10:49
 */
public interface OAuth2TokenDao {

    /**
     * 保存未授权的Request Token
     *
     * @param appKey                   应用key
     * @param appSecret                应用秘钥
     * @param unauthorizedRequestToken 未授权的Request Token
     * @return 未授权的Request Token
     */
    public String saveUnauthorizedRequestToken(String appKey, String appSecret, String unauthorizedRequestToken);

    /**
     * 保存用户授权的Request Token
     *
     * @param appKey                 应用key
     * @param appSecret              应用秘钥
     * @param authorizedRequestToken 用户授权的Request Token
     * @return 用户授权的Request Token
     */
    public String saveAuthorizedRequestToken(String appKey, String appSecret, String authorizedRequestToken);

    /**
     * 保存Access Token
     *
     * @param appKey      应用key
     * @param appSecret   应用秘钥
     * @param accessToken Access Token
     * @return Access Token
     */
    public String saveAccessToken(String appKey, String appSecret, String accessToken);

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
     * @param appKey    应用key
     * @param appSecret 应用秘钥
     * @return 用户授权的Request Token
     */
    public String getAuthorizedRequestToken(String appKey, String appSecret);

    /**
     * 获取Access Token
     *
     * @param appKey    应用key
     * @param appSecret 应用秘钥
     * @return Access Token
     */
    public String getAccessToken(String appKey, String appSecret);
}
