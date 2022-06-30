package reflection;

public class ClassStudy {

    public static void run(){
        /*获取class的三种方式*/
        Class cls = String.class;
//        System.out.println(cls);//class java.lang.String
        Class cls2 = "".getClass();
//        System.out.println(cls2);//class java.lang.String
        try{
            Class cls3 = Class.forName("java.lang.String");
//            System.out.println(cls3);//class java.lang.String
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        /*比较class*/
        //使用 equals 比较，用于精准比较，class必须相同
        //使用 instanceof 比较，只要是属于class或子class即可
        Integer i = Integer.valueOf("20");

        boolean b1 = i instanceof Integer;//true，因为n是Integer类型
        boolean b2 = i instanceof Number;//true，因为n是Number类型的子类
        boolean b3 = i.getClass().equals(Integer.class);//true，因为n.getClass()返回Integer.class
        boolean b4 = i.getClass().equals(Number.class);//false，因为Integer.class!=Number.class
//        System.out.println(b1);
//        System.out.println(b2);
//        System.out.println(b3);
//        System.out.println(b4);

        /*获取class信息*/
//        ClassInfo.print("".getClass());
//        ClassInfo.print(Runnable.class);
//        ClassInfo.print(java.time.Month.class);
//        ClassInfo.print(String[].class);
//        ClassInfo.print(int.class);

        /*动态加载class*/
        //JVM在执行Java程序的时候，并不是一次性把所有用到的class全部加载到内存，而是第一次需要用到class时才加载


    }
}

class ClassInfo{
    public  static void print(Class cls){
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
        System.out.println("-------------------------------------------------");
    }
    /*
    判断是否有class
     */
    public static boolean isClassPresent(String name){
        try{
            Class.forName(name);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}


/*
小结

JVM为每个加载的class及interface创建了对应的Class实例来保存class及interface的所有信息；

获取一个class对应的Class实例后，就可以获取该class的所有信息；

通过Class实例获取class信息的方法称为反射（Reflection）；

JVM总是动态加载class，可以在运行期根据条件来控制加载class。
 */
