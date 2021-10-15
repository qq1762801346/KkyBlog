package per.kky.demo.design.prototype;

import per.kky.demo.design.prototype.func.Shape;
import per.kky.demo.design.prototype.func.ShapeCache;

/**
 * 原型模式
 * 通过重写克隆方法来提高对象创建效率
 * 浅拷贝通过实现Clonable 深拷贝通过实现Serializable读取二进制流
 * 一般搭配工厂模式一起使用, 在创建对象代价较大的优化场景使用
 * 优点： 1、性能提高。 2、逃避构造函数的约束。
 * 缺点： 1、配备克隆方法需要对类的功能进行通盘考虑，这对于全新的类不是很难，但对于已有的类不一定很容易，特别当一个类引用不支持串行化的间接对象，或者引用含有循环结构的时候。 2、必须实现 Cloneable 接口。
 */
public class Prototype {

    public static void main(String[] args) {
        Shape cloneCircle = ShapeCache.getShape("1");
        cloneCircle.draw();

        Shape cloneRectangle = ShapeCache.getShape("2");
        cloneRectangle.draw();
    }

}
