package per.kky.design.factory;

import per.kky.design.factory.func.Animal;
import per.kky.design.factory.func.Cat;
import per.kky.design.factory.func.Dog;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单工厂模式
 * 优点: 统一对对象进行管理, 无需新建对象, 扩展性强
 * 缺点: 新建一个对象需要添加代码, 代码较长难于维护
 */
public class AnimalSimpleFactory {

    private static Map<String, Animal> factoryMap;

    static {
        factoryMap = new HashMap<>();
        factoryMap.put("Cat", new Cat());
        factoryMap.put("Dog", new Dog());
    }

    public static Animal getAnimal(String name) {
        return factoryMap.get(name);
    }

    public static Animal getAnimal(Class clazz) {
        return getAnimal(clazz.getSimpleName());
    }

}
