package per.kky.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import per.kky.common.base.BaseService;
import per.kky.common.dto.Kv;
import per.kky.modules.system.entity.User;
import per.kky.modules.system.vo.UserVO;

public interface IUserService extends BaseService<User> {

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
