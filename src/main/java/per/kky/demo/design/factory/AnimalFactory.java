package per.kky.demo.design.factory;

import per.kky.demo.design.factory.func.Animal;
import per.kky.demo.design.factory.func.Cat;
import per.kky.demo.design.factory.func.Color;
import per.kky.demo.design.factory.func.Dog;

import java.util.HashMap;
import java.util.Map;

public class AnimalFactory extends AbstractFactory {

    public Map<String, Animal> map = new HashMap<>();

    public AnimalFactory() {
        map.put("Cat", new Cat());
        map.put("Dog", new Dog());
    }

    @Override
    public Animal getAnimal(String animal) {
        return map.get(animal);
    }

    @Override
    public Animal getAnimal(Class clazz) {
        return getAnimal(clazz.getSimpleName());
    }

    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Color getColor(Class clazz) {
        return null;
    }
}
