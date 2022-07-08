package io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileStudy {
    public void run(){
        // File 对象,Java的标准库java.io提供了File对象来操作文件和目录
//        String filepath = "F:\\我的资料\\java\\base\\src\\io\\data\\test.txt";//绝对路径
//        String filepath = "./src/io/data/test.txt";//相对路径
        String filepath = ".";
        File f = new File(filepath);
        System.out.println(f.getPath());//.
        System.out.println(f.getAbsolutePath());//F:\我的资料\java\base\.
        try {
            System.out.println(f.getCanonicalPath());//F:\我的资料\java\base
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println(f.isFile());//false
        System.out.println(f.isDirectory());//true

        //遍历文件和目录
        File f2 = new File("./src/io/data");
        File[] fs1 = f2.listFiles();//列出所有文件和目录
        printFiles(fs1);
        File[] fs2 = f2.listFiles(new FilenameFilter() {//仅列出.txt文件
            @Override
            public boolean accept(File pathname,String name) {
                return name.endsWith(".txt");//返回true表示接受该文件
            }
        });
        printFiles(fs2);
        /*
        用File对象获取到一个文件时，还可以进一步判断文件的权限和大小：

    boolean canRead()：是否可读；
    boolean canWrite()：是否可写；
    boolean canExecute()：是否可执行；
    long length()：文件字节大小。
         */
        /*
        createNewFile()： 创建一个新文件
        delete()：删除该文件
        createTempFile()：创建一个临时文件
        deleteOnExit()：JVM退出时自动删除该文件
         */
        try {
            File tmp =  File.createTempFile("tmp-",".txt");//提供临时文件的前缀和后缀
            tmp.deleteOnExit();
            System.out.println(tmp.isFile());
            System.out.println(tmp.getAbsolutePath());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        /*
        File对象如果表示一个目录，可以通过以下方法创建和删除目录：

    boolean mkdir()：创建当前File对象表示的目录；
    boolean mkdirs()：创建当前File对象表示的目录，并在必要时将不存在的父目录也创建出来；
    boolean delete()：删除当前File对象表示的目录，当前目录必须为空才能删除成功。

         */

        //Path对象,它位于java.nio.file包。Path对象和File对象类似
        Path p1 = Paths.get(".","project","study");
        System.out.println(p1);//.\project\study
        //转换为绝对路径
        System.out.println(p1.toAbsolutePath());//F:\我的资料\java\base\.\project\study
        // 转换为规范路径
        System.out.println(p1.normalize());
        //转换为File对象
        File f3 = p1.toFile();
        System.out.println(f3);
        for (Path p : Paths.get("..").toAbsolutePath()) { // 可以直接遍历Path
            System.out.println("  " + p);
        }


    }

    static void printFiles(File[] files) {
        System.out.println("==========");
        if (files != null) {
            for (File f : files) {
                System.out.println(f);
            }
        }
        System.out.println("==========");
    }
}
