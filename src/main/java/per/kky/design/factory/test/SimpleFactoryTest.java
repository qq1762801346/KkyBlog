package per.kky.design.factory.test;

import per.kky.design.factory.AnimalSimpleFactory;
import per.kky.design.factory.func.Cat;

public class SimpleFactoryTest {

    public static void main(String[] args) {
        AnimalSimpleFactory.getAnimal("Cat").call();
        AnimalSimpleFactory.getAnimal(Cat.class).call();
    }

}
