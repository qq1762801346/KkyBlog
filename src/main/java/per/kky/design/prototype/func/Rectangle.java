package per.kky.design.prototype.func;

import lombok.Data;

@Data
public class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() methods.");
    }

}
