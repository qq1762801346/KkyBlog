package per.kky.modules.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wf.captcha.SpecCaptcha;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import per.kky.common.base.BaseServiceImpl;
import per.kky.common.dto.Kv;
import per.kky.common.util.JWTUtil;
import per.kky.common.util.RedisUtil;
import per.kky.modules.system.constant.SystemConstant;
import per.kky.modules.system.entity.User;
import per.kky.modules.system.mapper.UserMapper;
import per.kky.modules.system.service.IUserService;
import per.kky.modules.system.vo.UserVO;

import java.time.Duration;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements IUserService {

    private final UserMapper userMapper;
    private final RedisUtil redisUtil;

    @Override
    public Kv captcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(102, 36, 4);
        String key = UUID.randomUUID().toString();
        redisUtil.set(SystemConstant.CAPTCHA + key, specCaptcha.text().toLowerCase(), Duration.ofMinutes(1));
        return Kv.create().set("key", SystemConstant.CAPTCHA + key).set("code", specCaptcha.toBase64());
    }

    @Override
    public UserVO login(String account, String password) {
        User user = userMapper.selectOne(
                new LambdaQueryWrapper<User>()
                    .eq(User::getUserAcc, account)
                    .eq(User::getUserPwd, DigestUtil.sha1Hex(password))
                    .eq(User::getIsDeleted, 0)
        );
        if(user != null) {
            UserVO vo = Objects.requireNonNull(BeanUtil.copyProperties(user, UserVO.class));
            vo.setToken(JWTUtil.token(user));
            return vo;
        }
        return null;
    }
}
