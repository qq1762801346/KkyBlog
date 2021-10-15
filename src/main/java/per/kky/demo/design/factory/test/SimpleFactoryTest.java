package per.kky.demo.design.factory.test;

import per.kky.demo.design.factory.AnimalSimpleFactory;
import per.kky.demo.design.factory.func.Cat;

public class SimpleFactoryTest {

    public static void main(String[] args) {
        AnimalSimpleFactory.getAnimal("Cat").call();
        AnimalSimpleFactory.getAnimal(Cat.class).call();
    }

}
