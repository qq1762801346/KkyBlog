package per.kky.design.singleton;

/**
 * 双重检测单例
 * 优点: 对象被引用时才初始化, 线程安全, 通过双重检测的方式避免每次都要锁对象占用内存、时间
 */
public class DoubleCheckSingleton {

    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {

    }

    public static DoubleCheckSingleton getInstance() {
        if(instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if(instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

}
