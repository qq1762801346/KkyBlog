package per.kky.modules.system.util;

import cn.hutool.core.convert.Convert;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import per.kky.common.entity.BaseEntity;
import per.kky.modules.system.entity.User;

import javax.servlet.http.HttpServletRequest;

public class UserUtil {

    public static final String tokenName = "Kky-Token";

    public static HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return requestAttributes == null ? null : ((ServletRequestAttributes)requestAttributes).getRequest();
    }

    /**
     * 通过请求头部的jwt获取用户信息
     * @return
     */
    public static User getUser() {
        HttpServletRequest request = getRequest();
        if(request == null) {
            return null;
        } else {
            String token = request.getHeader(tokenName);
            DecodedJWT jwt = JWT.decode(token);

            User user = Convert.convert(User.class,
                    new User()
                            .setUserAcc(jwt.getClaim("userAcc").asString())
                            .setUserNick(jwt.getClaim("userNick").asString())
                            .setId(jwt.getClaim("id").asLong())
                            .setCreateDept(jwt.getClaim("createDept").asLong()));
            return user;
        }
    }

}
