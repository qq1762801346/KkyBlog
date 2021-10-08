package per.kky.design.factory;

import java.util.HashMap;
import java.util.Map;

public class AbstractFactoryProducer {

    private static Map<String, AbstractFactory> map = new HashMap<>();

    static {
        map.put("Color", new ColorFactory());
        map.put("Animal", new AnimalFactory());
    }

    public static AbstractFactory getFactory(String name) {
        return map.get(name);
    }

    public static AbstractFactory getFactory(Class clazz) {
        return getFactory(clazz.getSimpleName());
    }

}
