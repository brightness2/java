// 由于Java支持嵌套类，如果一个类内部还定义了嵌套类，那么，嵌套类拥有访问private的权限
public class Test3 {
    String name = "main";
    public static void main(String[] args) {
        Inner i = new Inner();
        System.out.println(i.hi());
    }

    // private方法:
    private static void hello() {
        System.out.println("private hello!");
    }

    // 静态内部类:
    //用static修饰的内部类和Inner Class有很大的不同，它不再依附于Outer的实例，而是一个完全独立的类，因此无法引用Outer.this，但它可以访问Outer的private静态字段和静态方法。如果把StaticNested移到Outer之外，就失去了访问private的权限。
    static class Inner {
        String name = "inner";
        public String hi() {
            Test3.hello();
            return name;// inner,this指的是Inner示例，
        }
    } 
}
