package per.kky.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import per.kky.modules.system.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JWTUtil {

    private static final long EXPIRE_DATE = 1000 * 3600;
    private static final String TOKEN_SECRET = "Kky-Blog";

    /**
     * 生成token
     *
     * @param user
     * @return
     */
    public static String token(User user) {
        String token = "";
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            //携带User对象信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("id", user.getId())
                    .withClaim("userAcc", user.getUserAcc())
                    .withClaim("userNick", user.getUserNick())
                    .withClaim("createDept", user.getCreateDept())
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return token;
    }

    /**
     * 验证token
     *
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            log.info("token已过期");
            return false;
        }
    }

}
