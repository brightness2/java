package com;
import  java.beans.*;
public class JavaBean {

    public void run() throws  Exception{
        //Introspector.getBeanInfo 需要进行exception 抛出 ，throws  Exception
        BeanInfo info = Introspector.getBeanInfo(Person.class);
        //使用Introspector.getBeanInfo()可以获取属性列表
        for(PropertyDescriptor pd : info.getPropertyDescriptors()){
            System.out.println(pd.getName());
            System.out.println(" " + pd.getReadMethod());
            System.out.println(" " + pd.getWriteMethod());
        }
    }
}
/*
javaBean类型
getter和setter也是一种数据封装的方法
JavaBean主要用来传递数据，即把一组数据组合成一个JavaBean便于传输。
要枚举一个JavaBean的所有属性，可以直接使用Java核心库提供的Introspector：
 */
class  Person{
    private  String name;
    private  int age;

    //读方法
    public String getName() {
        return name;
    }
    //写方法
    public void setName(String name) {
        this.name = name;
    }
    //读方法
    public int getAge() {
        return age;
    }
    //写方法
    public void setAge(int age) {
        this.age = age;
    }
    //boolean类型的读方法，只读属性
    public  Boolean isBig(){
        return age>15;
    }
}


