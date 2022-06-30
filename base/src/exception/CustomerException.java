package exception;

import java.util.Optional;

public class CustomerException extends BaseException {

    public CustomerException(String message){
        super(message);
    }
//如果调用方一定要根据null判断，比如返回null表示文件不存在，那么考虑返回Optional<T>,这样调用方必须通过Optional.isPresent()判断是否有结果。
    public Optional<String> isBig(int age){
        if (age<=0){
            return  Optional.empty();
        }else if (age<15){
            return Optional.of("小");
        }else{
            return Optional.of("大");
        }
    }

}

/**
 * BaseException需要从一个适合的Exception派生，通常建议从RuntimeException派生
 * 自定义的BaseException应该提供多个构造方法
 */
class BaseException extends RuntimeException{

    public BaseException(){
        super();
    }

    public BaseException(String message,Throwable cause){
        super(message,cause);
    }

    public BaseException(String message){
        super(message);
    }

    public BaseException(Throwable cause){
        super(cause);
    }
}

/*
Java标准库定义的常用异常包括：

Exception
│
├─ RuntimeException
│  │
│  ├─ NullPointerException
│  │
│  ├─ IndexOutOfBoundsException
│  │
│  ├─ SecurityException
│  │
│  └─ IllegalArgumentException
│     │
│     └─ NumberFormatException
│
├─ IOException
│  │
│  ├─ UnsupportedCharsetException
│  │
│  ├─ FileNotFoundException
│  │
│  └─ SocketException
│
├─ ParseException
│
├─ GeneralSecurityException
│
├─ SQLException
│
└─ TimeoutException

 */