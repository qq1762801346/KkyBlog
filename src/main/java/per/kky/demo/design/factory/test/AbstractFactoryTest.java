package per.kky.demo.design.factory.test;

import per.kky.demo.design.factory.AbstractFactoryProducer;
import per.kky.demo.design.factory.func.Animal;
import per.kky.demo.design.factory.func.Cat;
import per.kky.demo.design.factory.func.Color;
import per.kky.demo.design.factory.func.Red;

public class AbstractFactoryTest {

    public static void main(String[] args) {
        AbstractFactoryProducer.getFactory(Color.class).getColor(Red.class).draw();
        AbstractFactoryProducer.getFactory(Animal.class).getAnimal(Cat.class).call();
    }

}
