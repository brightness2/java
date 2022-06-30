public class Test {

    public static void main(String[] args){
    
      // System.out.println("Hello vscode!");

      // //创建Person类
      // Person p = new Person("lucy",18);
      // Student p = new Student("lucy",18,100);

      // System.out.println("name:"+p.getName());
      // System.out.println("age:"+p.getAge());
      // System.out.println("age:"+p.getScore());


      //  Scanner scanner = new Scanner(System.in); // 创建Scanner对象
      //   System.out.print("Input your name: "); // 打印提示
      //   String name = scanner.nextLine(); // 读取一行输入并获取字符串
      //   System.out.print("Input your age: "); // 打印提示
      //   float age = scanner.nextInt(); // 读取一行输入并获取整数
      //   System.out.printf("Hi, %s, you are %.2f\n", name, age); // 格式化输出

      // switch (1) {
      //   case 1:
          
      //     break;
      //   case 2:
      //     System.out.println("2");
      //     break;
      
      //   default:
      //     break;
      // }

      // int[] arr = {1,2,3,4,5,6,7,8,9,10};
      // for (int i = 0; i < arr.length; i++) {
      //   System.out.println(arr[i]);
      // }
      // for (int i : arr) {
      //   System.out.println(i);
      // }
      // System.out.println(Arrays.toString(arr));
    
      //冒泡排序
      // for (int i = 0; i < arr.length; i++) { // 循环次数
      //   for (int j = 0; j < arr.length - i - 1; j++) { // 循环次数
      //     if (arr[j] < arr[j + 1]) { // 如果前一个数大于后一个数
      //       int temp = arr[j]; // 将前一个数赋值给临时变量
      //       arr[j] = arr[j + 1]; // 将后一个数赋值给前一个数
      //       arr[j + 1] = temp; // 将临时变量赋值给后一个数
      //     }
      //   }
      // }
      // System.out.println(Arrays.toString(arr));

      // Dog dog = new redDog();
      // dog.cat = new Cat();
      // dog.name = "lucy";
      // dog.cat.age = 2;

      // dog.send();
      ArtBook.setDiscount(0.8);
      IShop b = new ArtBook();//一般类型使用接口IShop定义，不能是Book，因为ArtBook实现了IShop接口,Book中没有sale方法
      b.run();//可以直接运行interface 的default定义的方法
      b.sale();
    }
  
}

class Person{
  protected String name;
  protected int age;

  public  Person(String name,int age){
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }
  

  public int getAge() {
    return age;
  }
}

class Student extends Person{
  protected int score;

  public  Student(String name,int age,int score){
    super(name, age);
    this.score = score;
  }

  public int getScore() {
    return score;
  }

}

// 从Java 15开始，允许使用sealed修饰class，并通过permits明确写出能够从该class继承的子类名称。

sealed class Shape permits Rect, Circle, Triangle {

}

final class Rect extends Shape {

}

final class Circle extends Shape {

}

final class Triangle extends Shape {

}

//The type Ellipse extending a sealed class Shape should be a permitted subtype of ShapeJava(16779068)
// final class Ellipse  extends Shape {

// }

class Animal{
  protected String name;

  public String getName() {
      return name;
  }

}

/************组合************ */

class Cat extends Animal{
  protected int age;

  public int getAge() {
      return age;
  }
}


class Dog extends Animal{
  protected Cat cat;

  public void send(){
    System.out.println("send age-"+cat.getAge());
  }
}

// 覆写

class redDog extends Dog{
 
  @Override //覆写
  public void send() {
    System.out.println("send red dog age-"+cat.getAge());
  }
}

//抽象类
abstract class Book{
  protected int number;
  public abstract double getPrice();
}

//接口
interface IShop{
  void sale();//相当于 public abstract void sale();

  default void run(){
    System.out.println("interface default function\n");
  }
}

//接口继承接口
interface ISuperShop extends IShop{
  String address();
}

class ArtBook extends Book implements IShop{

  public static double discount ;

  @Override
  public double getPrice(){
    return 20 * ArtBook.discount;
  }


  @Override
  public void sale() {
      System.out.printf("price="+this.getPrice());
      
  }

  public static void setDiscount(double number){
      ArtBook.discount = number;
  }
}