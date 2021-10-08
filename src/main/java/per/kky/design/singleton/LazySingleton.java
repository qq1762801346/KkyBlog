package per.kky.design.singleton;

/**
 * 懒汉式单例
 * 优点: 当对象被引用时进行初始化
 * 缺点: 每次获取对象时都要进行加锁操作, 浪费内存和时间
 */
public class LazySingleton {

    /**
     * new 对象分为三步骤
     * 1. 分配空间
     * 2. 初始化对象
     * 3. 将指针指向地址
     *
     * volatile的用处
     * 1. 防止指令重排序
     * 2. 使该变量对任何线程可见 (修改时其他线程都会立刻看到)
     */
    private static volatile LazySingleton instance;

    /**
     * 避免类在外部外被实例化
     */
    private LazySingleton() {

    }

    /**
     * 通过 synchronize 关键字保证线程安全
     * 避免对象在多线程中被初始化两次
     * @return
     */
    public static synchronized LazySingleton getInstance() {
        if(instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
