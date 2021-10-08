package per.kky.common.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import per.kky.modules.system.entity.User;

import javax.servlet.http.HttpServletRequest;

public class UserUtil {

    public static HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return requestAttributes == null ? null : ((ServletRequestAttributes)requestAttributes).getRequest();
    }

    public static User getUser() {
        HttpServletRequest request = getRequest();
        if(request == null) {
            return null;
        }
        return new User();
    }

}
