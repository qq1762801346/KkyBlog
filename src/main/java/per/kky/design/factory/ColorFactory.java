package per.kky.design.factory;

import per.kky.design.factory.func.Animal;
import per.kky.design.factory.func.Blue;
import per.kky.design.factory.func.Color;
import per.kky.design.factory.func.Red;

import java.util.HashMap;
import java.util.Map;

public class ColorFactory extends AbstractFactory {

    public Map<String, Color> map = new HashMap<>();

    public ColorFactory() {
        map.put("Blue", new Blue());
        map.put("Red", new Red());
    }

    @Override
    public Color getColor(String color) {
        return map.get(color);
    }

    @Override
    public Color getColor(Class clazz) {
        return getColor(clazz.getSimpleName());
    }

    @Override
    public Animal getAnimal(String color) {
        return null;
    }

    @Override
    public Animal getAnimal(Class clazz) {
        return null;
    }
}
