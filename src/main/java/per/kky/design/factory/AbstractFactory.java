package per.kky.design.factory;

import per.kky.design.factory.func.Animal;
import per.kky.design.factory.func.Color;

/**
 * 抽象工厂模式
 */
public abstract class AbstractFactory {

    public abstract Color getColor(String animal);
    public abstract Color getColor(Class clazz);

    public abstract Animal getAnimal(String color);
    public abstract Animal getAnimal(Class clazz);

}
