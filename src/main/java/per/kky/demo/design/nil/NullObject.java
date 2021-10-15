package per.kky.demo.design.nil;

import per.kky.demo.design.nil.func.AbstractCustomer;
import per.kky.demo.design.nil.func.CustomerFactory;

/**
 * 空指针模式
 * 避免空指针情况下的手动判断
 */
public class NullObject {

    public static void main(String[] args) {
        AbstractCustomer abstractCustomer1 = CustomerFactory.getCustomer("Bob");
        System.out.println(abstractCustomer1.getName());
        AbstractCustomer abstractCustomer2 = CustomerFactory.getCustomer("Jane");
        System.out.println(abstractCustomer2.getName());
        AbstractCustomer abstractCustomer3 = CustomerFactory.getCustomer("John");
        System.out.println(abstractCustomer3.getName());
    }

}
