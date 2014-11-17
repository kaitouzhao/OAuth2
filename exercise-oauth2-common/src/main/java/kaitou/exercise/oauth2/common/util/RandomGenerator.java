package kaitou.exercise.oauth2.common.util;

import java.util.Random;

/**
 * 随机数生成器.
 * User: 赵立伟
 * Date: 2014/5/29
 * Time: 10:27
 */
public abstract class RandomGenerator {

    private static final String BASE_STR = "abcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * 生成随机串
     * <p>
     * 包含26个字母及0~9数字
     * </p>
     *
     * @param length 随机串长度
     * @return 随机串
     */
    public static String getRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(BASE_STR.length());
            sb.append(BASE_STR.charAt(num));
        }
        return sb.toString();
    }
}
