package per.kky.modules.system.service;

import per.kky.common.dto.Kv;
import per.kky.modules.system.vo.UserVO;

public interface IUserService {

    /**
     * 获取验证码
     * @return
     */
    Kv captcha();

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    UserVO login(String account, String password);

}
