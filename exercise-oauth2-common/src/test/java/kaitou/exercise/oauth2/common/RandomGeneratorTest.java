package kaitou.exercise.oauth2.common;

import junit.framework.TestCase;

import static kaitou.exercise.oauth2.common.util.RandomGenerator.*;

/**
 * Created with IntelliJ IDEA.
 * User: 赵立伟
 * Date: 2014/5/29
 * Time: 10:34
 */
public class RandomGeneratorTest extends TestCase {

    public void testGetRandomString() throws Exception {
        for (int i = 0; i < 3; i++) {
            System.out.println(getRandomString(6));
        }
    }
}
