package per.kky.demo.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class LambdaDemo {

    /**
     * lambda表达式
     * 可以用于重写单个方法的接口/抽象类
     */
    @Test
    public void Lambda() {
        new Thread(() -> {
            System.out.println(1);
        }).start();
        // 等同于
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });



        List<Integer> list = Arrays.asList(3, 2, 4, 1);
        list.sort((o1, o2) -> {
            return o1 - o2;
        });
        // 等同于
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

}
