package exception;


public class TypeException {

    public void run(){
        //常见异常类型
        String s = "abc";
//        int n = Integer.parseInt(s); // NumberFormatException!
        // 用户删除了该文件：
//        String t = readFile("C:\\abc.txt"); // FileNotFoundException!
// SecurityException ,IOException ,Exception

        //捕获异常
//        try {
//           String s = processFile("c:\\test.txt");
//        }catch (FileNotFoundException e){
//            // file not found:
//        }catch (SecurityException e){
//            // no read permission:
//        }catch (IOException e){
//            // io error:
//        }catch (Exception e){
//            // other error:
//        }

        try {
            this.run2();
        }catch (Exception e){
            System.out.println("run2 throw Exception");
            //打印异常栈
            e.printStackTrace();
        } finally {
            System.out.println("无论是否有异常，都执行，例如清理工作");
        }
    }

    /*
    在方法定义的时候，使用throws Xxx表示该方法可能抛出的异常类型。调用方在调用的时候，必须强制捕获这些异常，否则编译器会报错
     */
    public void run2() throws Exception{

    }
}
/*
ava规定：

    必须捕获的异常，包括Exception及其子类，但不包括RuntimeException及其子类，这种类型的异常称为Checked Exception。

    不需要捕获的异常，包括Error及其子类，RuntimeException及其子类。

 */

