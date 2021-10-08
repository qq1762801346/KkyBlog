package per.kky.design.builder.func;

public abstract class Drink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }
}
