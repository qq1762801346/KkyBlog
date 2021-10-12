import com.wf.captcha.SpecCaptcha;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import per.kky.Application;
import per.kky.common.util.RedisUtil;
import per.kky.modules.system.service.IMenuService;
import per.kky.modules.system.vo.MenuVO;

import java.util.List;

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringTest {

    @Autowired
    private IMenuService menuService;

    @Test
    public void testRedis() {
        List<MenuVO> list = menuService.initRouters();
        System.out.println(list);
    }

}
