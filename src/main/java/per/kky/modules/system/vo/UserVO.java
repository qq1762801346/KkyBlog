package per.kky.modules.system.vo;

import lombok.Data;
import per.kky.modules.system.entity.User;

@Data
public class UserVO extends User {

    private String token;

    private String key;

    private String captcha;

}
