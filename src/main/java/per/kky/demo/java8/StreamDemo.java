package per.kky.demo.java8;


import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据。
 * Stream 使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象。
 * Stream API可以极大提高Java程序员的生产力，让程序员写出高效率、干净、简洁的代码。
 * 这种风格将要处理的元素集合看作一种流， 流在管道中传输， 并且可以在管道的节点上进行处理， 比如筛选， 排序，聚合等。
 * 元素流在管道中经过中间操作（intermediate operation）的处理，最后由最终操作(terminal operation)得到前面处理的结果。
 */
public class StreamDemo {


    /**
     * filter
     * 用于过滤指定条件元素
     * collect(Collectors.xxx())
     * 可以将流转换为各种类型
     */
    @Test
    public void filterStream() {
        List<String> list = Arrays.asList("abc", "", "cd", "", "null");
        List<String> filterList = list.stream().filter(s -> (
                !s.isEmpty()
        )).collect(Collectors.toList());
        System.out.println(filterList);
    }

    /**
     * map
     * 用于计算
     * distinct
     * 用于过滤重复元素
     * sorted
     * 用于排序(默认从小到大)
     */
    @Test
    public void mapStream() {
        List<Integer> list = Arrays.asList(1, 6, 6, 4, 5);
        List<Integer> mapList = list.stream().map(s -> (
                s * s
        )).distinct().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }).collect(Collectors.toList());
        System.out.println(mapList);
    }

    /**
     *  forEach
     *  用于遍历
     *  limit
     *  用于限制数量
     */
    @Test
    public void forEachStream() {
        Random random = new Random();
        random.ints(-10, 10).limit(10).forEach(System.out::println);
    }

    /**
     * mapToXxx
     * 将流元素格式转换
     * summaryStatistics
     * 对于int float double的流格式可以进行统计
     */
    @Test
    public void summaryStream() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        IntSummaryStatistics total = list.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("最大值: " + total.getMax());
        System.out.println("最小值: " + total.getMin());
        System.out.println("平均值: " + total.getAverage());
        System.out.println("数量: " + total.getCount());
        System.out.println("总和: " + total.getSum());
    }

    /**
     * parallel
     * 并行
     */
    @Test
    public void parallelStream() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        list.stream().parallel().forEach(System.out::println);
        list.parallelStream().forEach(System.out::println);
    }

}
