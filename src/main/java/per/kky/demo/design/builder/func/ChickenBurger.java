package per.kky.demo.design.builder.func;

public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "chicken burger";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
