package com;

import exception.*;
import reflection.*;
import reflection.FieldStudy;

public class Main {

    public static void main(String[] args) {

        StringStudy stringObj = new StringStudy();
//        stringObj.sayHello();
//        stringObj.builder();
//        stringObj.box();
        JavaBean bean = new JavaBean();
//        try {
//            bean.run();
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }

        EnumStudy e = new EnumStudy();
//        e.run();
        RecordStudy r = new RecordStudy();
//        r.run();
        BigIntegerStudy bi = new BigIntegerStudy();
//        bi.run();
        BigDecimalStudy bd = new BigDecimalStudy();
//        bd.run();
        Tool t = new Tool();
//        t.run();
        /***************Exception********************/
//        test1.run();
        /****************Reflection**********************/
        test2.run();


    }

}

class test1{

    public static void run(){
        TypeException t = new TypeException();
//        t.run();
//        throw  new CustomerException("自定义异常类");
//        LoggingStudy.run();
//        LoggingStudy.run2();
        LoggingStudy.run3();

    }
}

class test2{
    public static void run(){
//        ClassStudy.run();
//        try{
//            FieldStudy.run();
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        try{
//            MethodStudy.run();
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        ParentClass.fun();

        DynamicProxy.run();

    }
}
