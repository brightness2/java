import com.Person;
//在写import的时候，可以使用*，表示把这个包下面的所有class都导入进来（但不包括子包的class）
//还有一种import static的语法，它可以导入可以导入一个类的静态字段和静态方法
public class Test2 {
    
    public static void main(String[] args) {
        Person p = new Person("lucy");
        String name = p.getName();
        System.out.println(name);
        System.out.println(p.getWeight());

    }
  
}

//终端中支持单文件运行，运行跨包的代码需要指定运行环境
//& 'D:\JAVA\jdk-17.0.2\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\jh.zeng\AppData\Roaming\Code\User\workspaceStorage\5ce6b1ed469c87d8fd4595f351548daa\redhat.java\jdt_ws\study_3a98d208\bin' 'Test2'
