package kaitou.exercise.oauth2.service.provider.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import kaitou.exercise.oauth2.dao.OAuth2TokenDao;
import kaitou.exercise.oauth2.dao.redis.OAuth2TokenDaoImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

import static kaitou.exercise.oauth2.common.util.SpringContextUtils.getBean;
import static kaitou.exercise.oauth2.common.util.StringUtils.isEmpty;

/**
 * 校验Access Token.
 * User: 赵立伟
 * Date: 2014/5/29
 * Time: 15:15
 */
public class CheckAccessTokenInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String appKey = request.getParameter("app_key");
        String appSecret = request.getParameter("app_secret");
        OAuth2TokenDao oAuth2TokenDao = getBean("oAuth2TokenDao", OAuth2TokenDaoImpl.class);
        String accessToken1 = oAuth2TokenDao.getAccessToken(appKey, appSecret);
        if (isEmpty(accessToken1)) {
            return "login";
        }
        String accessToken = request.getParameter("access_token");
        if (!accessToken.equalsIgnoreCase(accessToken1)) {
            return "error";
        }
        return invocation.invoke();
    }
}
