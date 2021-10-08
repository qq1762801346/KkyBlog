package per.kky.design.builder.func;

public class Coke extends Drink {
    @Override
    public String name() {
        return "coke drink";
    }

    @Override
    public float price() {
        return 6.0f;
    }
}
