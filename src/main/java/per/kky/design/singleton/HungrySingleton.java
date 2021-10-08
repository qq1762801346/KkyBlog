package per.kky.design.singleton;

/**
 * 饿汉式单例
 * 缺点: 当类被引用时初始化
 * 优点: 本身就是线程安全的
 */
public class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }

}
