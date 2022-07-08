package conllection;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesStudy {
    public static void run(){
        /*
        读取配置文件
        用Properties读取配置文件非常简单
        用Properties读取配置文件，一共有三步：

    创建Properties实例；
    调用load()读取文件；
    调用getProperty()获取配置。

         */
        String f = "F:/我的资料/java/base/src/conllection/data/test.properties";
        Properties props = new Properties();
        try {
            props.load(new FileReader(f, StandardCharsets.UTF_8));
            String name = props.getProperty("name");
            String language = props.getProperty("language","120");
            String a = props.getProperty("a");
            System.out.println(name);///data/hello.txt
            System.out.println(language);///60
            System.out.println(a);//null
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            //从内存中读取一个字节流
            String settings = "# test" + "\n" + "course=Java" + "\n" + "last_open_date=2019-08-07T12:35:01";
            ByteArrayInputStream input = new ByteArrayInputStream(settings.getBytes("UTF-8"));
            Properties props2 = new Properties();
            props2.load(input);
            System.out.println(props2.getProperty("last_open_date"));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static  void run2(){
        //写入配置文件
        String f = "F:/我的资料/java/base/src/conllection/data/test.properties";
        Properties props = new Properties();
        props.setProperty("name","Brightness");
        props.setProperty("language","java");
        try{
            //覆盖文件写入
            props.store(new FileOutputStream(f),"这是写入的properties注释");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
/*
小结

Java集合库提供的Properties用于读写配置文件.properties。.properties文件可以使用UTF-8编码。

可以从文件系统、classpath或其他任何地方读取.properties文件。

读写Properties时，注意仅使用getProperty()和setProperty()方法，不要调用继承而来的get()和put()等方法。
 */