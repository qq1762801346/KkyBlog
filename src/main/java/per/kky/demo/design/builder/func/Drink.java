package per.kky.demo.design.builder.func;

public abstract class Drink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }
}
