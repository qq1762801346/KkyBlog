import com.wf.captcha.SpecCaptcha;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import per.kky.Application;
import per.kky.common.util.RedisUtil;
import per.kky.modules.system.entity.User;
import per.kky.modules.system.service.IMenuService;
import per.kky.modules.system.service.IUserService;
import per.kky.modules.system.vo.MenuVO;

import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testRedis() {
        User user = userService.getById(1);
        user.setUserNick("张三" + new Random().nextInt(10));
        userService.saveOrUpdate(user);
        User user2 = new User();
        user2.setId(5L);
        user2.setUserNick("王五");
        userService.saveOrUpdate(user2);
    }

}
