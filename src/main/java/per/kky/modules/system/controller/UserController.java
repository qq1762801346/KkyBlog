package per.kky.modules.system.controller;

import com.sun.org.apache.bcel.internal.generic.IUSHR;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.kky.common.dto.Kv;
import per.kky.common.dto.R;
import per.kky.common.exception.ServiceException;
import per.kky.common.util.RedisUtil;
import per.kky.modules.system.constant.SystemConstant;
import per.kky.modules.system.entity.User;
import per.kky.modules.system.service.IUserService;
import per.kky.modules.system.vo.UserVO;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/kky-system/user")
public class UserController {

    private final IUserService userService;
    private final RedisUtil redisUtil;

    @PostMapping("/captcha")
    public Kv captcha() {
        return userService.captcha();
    }

    @PostMapping("/login")
    public R login(@RequestBody UserVO user) {
        // 校验验证码
        if(redisUtil.get(user.getKey()) == null) {
            throw new ServiceException("验证码已失效, 请刷新");
        } else if(!redisUtil.get(user.getKey()).equalsIgnoreCase(user.getCaptcha())) {
            throw new ServiceException("验证码错误.");
        }
        // 校验账号密码
        UserVO vo = userService.login(user.getUserAcc(), user.getUserPwd());
        if(vo == null) {
            throw new ServiceException("账号或密码错误");
        } else if(vo.getStatus() == SystemConstant.USER_STATUS_FREEZE) {
            throw new ServiceException("账号已被冻结");
        } else {
            return R.data(vo);
        }
    }

}
