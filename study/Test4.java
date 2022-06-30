import com.Outer;
public class Test4 {

    public static void main(String[] args) {
        
        Outer o = new Outer();
        // o.run();
        // 实例化内部类，注意内部类要public修饰，不然不可见
        Outer.Inner i =  o.new Inner();
        System.out.println("outer name ="+i.getOuterName());
        System.out.println("inner name ="+i.getInnerName());
    }
    
}
