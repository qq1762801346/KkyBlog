package per.kky.demo.design.builder.func;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }
    
}
