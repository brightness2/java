package com;

import annotation.AnnotationStudy;
import conllection.*;
import date.DateAndTime;
import date.LocalDateTimeStudy;
import exception.*;
import generics.*;
import io.*;
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
//        test2.run();
        /*****************Generics*************************/
//        test3.run();
        /******************Conlletions*****************/
//        test4.run();
        /*******************IO******************/
//        test5.run();
        /********日期与时间******/
        test6.run();
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

//        DynamicProxy.run();

//        AnnotationStudy.run();


    }
}

class test3{
    static void run(){
//        Gen.run();
//        Gen2.run();
//        TypeErasure.run();
//        Extend.run();
//        Extend2.run();
//        Sup.run();
    }
}

class test4{
    static void run(){
//        ListStudy.run();
//        MapStudy.run();
//        MapStudy.run2();
//        EnumMapStudy.run();
//        TreeMapStudy.run();
//        PropertiesStudy.run();
//         PropertiesStudy.run2();
//         SetStudy.run();
//         QueueStudy.run();
//        QueueStudy.run2();
//        QueueStudy.run3();
//        DQueueStudy.run();
        StackStudy.run();
    }
}

class test5{
    static void run(){
//        (new FileStudy()).run();
        try{
//            (new InputStreamStudy()).run();
//            (new OutStreamStudy()).run();
//            (new FilterStudy()).run();
//            (new ClasspathStudy()).run();
//            (new SerializableStudy()).run();
//            (new ReaderStudy()).run();
//            (new WriterStudy()).run();
            (new FilesStudy()).run();
        }catch (Exception e){
            System.out.println(e.getMessage());
        };
    }
}

class test6{
    static void run(){
//        DateAndTime.run();
//        DateAndTime.run2();
//        LocalDateTimeStudy.run();
        LocalDateTimeStudy.run2();
    }

}
