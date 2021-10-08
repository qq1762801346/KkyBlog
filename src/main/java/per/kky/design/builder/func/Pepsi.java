package per.kky.design.builder.func;

public class Pepsi extends Drink {
    @Override
    public String name() {
        return "pepsi drink";
    }

    @Override
    public float price() {
        return 10.0f;
    }
}
