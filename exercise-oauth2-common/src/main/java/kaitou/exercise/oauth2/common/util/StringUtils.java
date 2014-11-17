package kaitou.exercise.oauth2.common.util;

/**
 * String工具类.
 * User: 赵立伟
 * Date: 2014/5/29
 * Time: 12:41
 */
public abstract class StringUtils {

    /**
     * 判空
     *
     * @param str 字符串
     * @return 为null或空串则为真
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equalsIgnoreCase(str.trim());
    }
}
