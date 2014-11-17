package kaitou.exercise.oauth2.service.provider.service.impl;

import kaitou.exercise.oauth2.common.OAuth2Exception;
import kaitou.exercise.oauth2.dao.OAuth2TokenDao;
import kaitou.exercise.oauth2.service.provider.service.OAuth2TokenService;

import static kaitou.exercise.oauth2.common.util.RandomGenerator.getRandomString;
import static kaitou.exercise.oauth2.common.util.StringUtils.isEmpty;

/**
 * Created with IntelliJ IDEA.
 * User: 赵立伟
 * Date: 2014/5/29
 * Time: 10:10
 */
public class OAuth2TokenServiceImpl implements OAuth2TokenService {

    private static final String APP_KEY = "appKey1";
    private static final String APP_SECRET = "appSecret1";

    private OAuth2TokenDao oAuth2TokenDao;

    public void setoAuth2TokenDao(OAuth2TokenDao oAuth2TokenDao) {
        this.oAuth2TokenDao = oAuth2TokenDao;
    }

    @Override
    public String getUnauthorizedRequestToken(String appKey, String appSecret) {
        checkApp(appKey, appSecret);
        String unauthorizedRequestToken = getRandomString(6);
        return oAuth2TokenDao.saveUnauthorizedRequestToken(appKey, appSecret, unauthorizedRequestToken);
    }

    private void checkApp(String appKey, String appSecret) {
        if (!APP_KEY.equalsIgnoreCase(appKey) || !APP_SECRET.equalsIgnoreCase(appSecret)) {
            throw new OAuth2Exception("Invalid app");
        }
    }

    @Override
    public String getAuthorizedRequestToken(String appKey, String appSecret, String unauthorizedRequestToken) {
        checkApp(appKey, appSecret);
        String unauthorizedRequestToken1 = oAuth2TokenDao.getUnauthorizedRequestToken(appKey, appSecret);
        if (isEmpty(unauthorizedRequestToken1) || !unauthorizedRequestToken1.equalsIgnoreCase(unauthorizedRequestToken)) {
            throw new OAuth2Exception("Invalid unauthorizedRequestToken.");
        }
        String authorizedRequestToken = getRandomString(6);
        return oAuth2TokenDao.saveAuthorizedRequestToken(appKey, appSecret, authorizedRequestToken);
    }

    @Override
    public String getAccessToken(String appKey, String appSecret, String authorizedRequestToken) {
        checkApp(appKey, appSecret);
        String authorizedRequestToken1 = oAuth2TokenDao.getAuthorizedRequestToken(appKey, appSecret);
        if (isEmpty(authorizedRequestToken1) || !authorizedRequestToken1.equalsIgnoreCase(authorizedRequestToken)) {
            throw new OAuth2Exception("Invalid authorizedRequestToken.");
        }
        String accessToken = getRandomString(6);
        return oAuth2TokenDao.saveAccessToken(appKey, appSecret, accessToken);
    }
}
