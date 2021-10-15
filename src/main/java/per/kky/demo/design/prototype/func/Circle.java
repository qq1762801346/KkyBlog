package per.kky.demo.design.prototype.func;

import lombok.Data;

@Data
public class Circle extends Shape {

    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
