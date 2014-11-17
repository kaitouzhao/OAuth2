package kaitou.exercise.oauth2.service.provider.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 模拟服务.
 * User: 赵立伟
 * Date: 2014/5/29
 * Time: 15:25
 */
public class MockProviderAction extends ActionSupport {

    private String message;

    public String getMessage() {
        return message;
    }

    public String provider1() {
        message = "Provider1 is ok.";
        return SUCCESS;
    }
}
