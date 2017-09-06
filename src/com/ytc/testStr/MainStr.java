package com.ytc.testStr;

/**
 * Created by Administrator on 2017/9/6.
 */
public class MainStr {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setAge(3);
        stu.setStuName("rose");
        Address address = new Address();
        address.setAddressName("wolegequ");
        stu.setAddress(address);

        Student stu2 = new Student(stu);

        System.out.println(stu.equals(stu2));
        System.out.println(stu.hashCode());
        System.out.println(stu2.hashCode());
        System.out.println(stu == stu2);
        System.out.println("-------------------");
        System.out.println(stu.getAddress().getAddressName());
        System.out.println(stu2.getAddress().getAddressName());
        stu2.getAddress().setAddressName("shanghailujiazui");
        stu2.setStuName("merry");
        System.out.println(".......................");
        System.out.println(stu.getAddress().getAddressName());
        System.out.println(stu2.getAddress().getAddressName());
        System.out.println(stu.getStuName());
        System.out.println(stu2.getStuName());
        System.out.println(stu.equals(stu2));
        System.out.println(stu.hashCode());
        System.out.println(stu2.hashCode());
        System.out.println(stu == stu2);
    }
}
