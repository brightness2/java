package exception;

import java.util.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoggingStudy {
    protected  final  Log log = LogFactory.getLog(getClass());//用于实例中调用
    public static void run(){
        Logger logger = Logger.getGlobal();
        logger.info("start process");
        logger.warning("memory is running out...");
        logger.fine("ignored");
        logger.severe("process will be terminated");
        /*
        JDK的Logging定义了7个日志级别，从严重到普通：
        SEVERE
        WARNING
        INFO
        CONFIG
        FINE
        FINER
        FINEST
        因为默认级别是INFO，因此，INFO级别以下的日志，不会被打印出来
         */

        Logger logger2 = Logger.getLogger(LoggingStudy.class.getName());
        logger2.info("end process");
    }

    public static void  run2(){
        //使用第三方日志库 Commons Logging
        Log log = LogFactory.getLog(LoggingStudy.class);
        log.info("start...");
        log.warn("end.");
    }

    public static void run3(){
        //使用log4j
        /*
        console：输出到屏幕；
        file：输出到文件；
        socket：通过网络输出到远程计算机；
        jdbc：输出到数据库
         */

    }
}
