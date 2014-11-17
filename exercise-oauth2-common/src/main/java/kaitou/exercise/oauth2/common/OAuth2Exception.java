package kaitou.exercise.oauth2.common;

/**
 * 自定义异常.
 * User: 赵立伟
 * Date: 2014/5/29
 * Time: 12:38
 */
public class OAuth2Exception extends RuntimeException {

    public OAuth2Exception() {
    }

    public OAuth2Exception(String message) {
        super(message);
    }

    public OAuth2Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public OAuth2Exception(Throwable cause) {
        super(cause);
    }

    public OAuth2Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
