package com;
public class Person {
    String name;
    byte sex;
    int age;

    public Person(String name){
        this.name = name;

    }

    public String getName(){
        return this.name;
    }

    public double getWeight(){
        return A.weight;//可以访问同一个包作用域的字段
    }
}

