package kaitou.exercise.oauth2.dao.redis;

import com.taobao.common.tedis.atomic.Tedis;
import kaitou.exercise.oauth2.common.OAuth2Exception;
import kaitou.exercise.oauth2.dao.OAuth2TokenDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import redis.clients.jedis.Jedis;

import java.io.UnsupportedEncodingException;

/**
 * Token数据服务缓存实现.
 * User: 赵立伟
 * Date: 2014/5/29
 * Time: 10:58
 */
public class OAuth2TokenDaoImpl implements OAuth2TokenDao {

    private final Log log = LogFactory.getLog(getClass());

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 6379;
    private static final String UNAUTHORIZED_REQUEST_TOKEN_KEY = "tedis:unauthorized:rt:%s:%s";
    private static final String AUTHORIZED_REQUEST_TOKEN = "tedis:authorized:rt:%s:%s";
    private static final String ACCESS_TOKEN_KEY = "tedis:access:token:%s:%s";
    private static final int REQUEST_TOKEN_LIVE = 180;
    public static final int ACCESS_TOKEN_LIVE = 3600;

    private Jedis jedis = new Jedis(HOST, PORT);
    private Tedis tedis = new Tedis(HOST, PORT);

    @Override
    public String saveUnauthorizedRequestToken(String appKey, String appSecret, String unauthorizedRequestToken) {
        String key = String.format(UNAUTHORIZED_REQUEST_TOKEN_KEY, appKey, appSecret);
//        jedis.set(key, unauthorizedRequestToken);
//        jedis.expire(key, REQUEST_TOKEN_LIVE);
        tedis.set(key.getBytes(), unauthorizedRequestToken.getBytes());
        tedis.expire(key.getBytes(), REQUEST_TOKEN_LIVE);
        return unauthorizedRequestToken;
    }

    @Override
    public String saveAuthorizedRequestToken(String appKey, String appSecret, String authorizedRequestToken) {
        String key = String.format(AUTHORIZED_REQUEST_TOKEN, appKey, appSecret);
//        jedis.set(key, authorizedRequestToken);
//        jedis.expire(key, REQUEST_TOKEN_LIVE);
        tedis.set(key.getBytes(), authorizedRequestToken.getBytes());
        tedis.expire(key.getBytes(), REQUEST_TOKEN_LIVE);
        return authorizedRequestToken;
    }

    @Override
    public String saveAccessToken(String appKey, String appSecret, String accessToken) {
        String key = String.format(ACCESS_TOKEN_KEY, appKey, appSecret);
//        jedis.set(key, accessToken);
//        jedis.expire(key, REQUEST_TOKEN_LIVE);
        tedis.set(key.getBytes(), accessToken.getBytes());
        tedis.expire(key.getBytes(), ACCESS_TOKEN_LIVE);
        return accessToken;
    }

    @Override
    public String getUnauthorizedRequestToken(String appKey, String appSecret) {
        String key = String.format(UNAUTHORIZED_REQUEST_TOKEN_KEY, appKey, appSecret);
//        return jedis.get(key);
        try {
            byte[] bytes = tedis.get(key.getBytes());
            if (bytes == null) {
                return "";
            }
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new OAuth2Exception(e);
        }
    }

    @Override
    public String getAuthorizedRequestToken(String appKey, String appSecret) {
        String key = String.format(AUTHORIZED_REQUEST_TOKEN, appKey, appSecret);
//        return jedis.get(key);
        try {
            byte[] bytes = tedis.get(key.getBytes());
            if (bytes == null) {
                return "";
            }
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new OAuth2Exception(e);
        }
    }

    @Override
    public String getAccessToken(String appKey, String appSecret) {
        String key = String.format(ACCESS_TOKEN_KEY, appKey, appSecret);
//        return jedis.get(key);
        try {
            byte[] bytes = tedis.get(key.getBytes());
            if (bytes == null) {
                return "";
            }
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new OAuth2Exception(e);
        }
    }

}
