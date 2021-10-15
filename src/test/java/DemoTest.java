import cn.hutool.core.convert.Convert;
import org.junit.Test;

import java.util.List;

public class DemoTest {

    @Test
    public void test() {
        String ids = "1,2,3,4,5,6,7";
        List<Long> list = Convert.toList(Long.class, ids);
        System.out.println(list);
    }

}
