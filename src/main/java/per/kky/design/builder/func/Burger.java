package per.kky.design.builder.func;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }
    
}
