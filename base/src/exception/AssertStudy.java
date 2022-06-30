package exception;
//断言
public class AssertStudy {

    public void run(){
        //使用assert关键字来实现断言
        double x = Math.abs(-123.45);
        assert x >= 0;
//        语句assert x >= 0;即为断言，断言条件x >= 0预期为true。如果计算结果为false，则断言失败，抛出AssertionError。
//        使用assert语句时，还可以添加一个可选的断言消息：

        assert x >= 0 : "x must >= 0";
//Java断言的特点是：断言失败时会抛出AssertionError，导致程序结束退出。因此，断言不能用于可恢复的程序错误，只应该用于开发和测试阶段。
        //要执行assert语句，必须给Java虚拟机传递-enableassertions（可简写为-ea）参数启用断言
    }
}
