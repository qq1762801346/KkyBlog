package per.kky.demo.design.prototype.func;

import java.util.Hashtable;

public class ShapeCache {

    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    static {
        Shape circle = new Circle().setId("1").setType("Circle");
        Shape rectangle = new Rectangle().setId("2").setType("Rectangle");
        shapeMap.put(circle.getId(), circle);
        shapeMap.put(rectangle.getId(), rectangle);
    }

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return cachedShape.clone();
    }

}
