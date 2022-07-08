package io;

import java.io.*;
import java.util.Arrays;

public class SerializableStudy {
    public void run() throws Exception {
        /*
        序列化是指把一个Java对象变成二进制内容，本质上就是一个byte[]数组。

为什么要把Java对象序列化呢？因为序列化后可以把byte[]保存到文件中，或者把byte[]通过网络传输到远程，这样，就相当于把Java对象存储到文件或者通过网络传输出去了。

有序列化，就有反序列化，即把一个二进制内容（也就是byte[]数组）变回Java对象。有了反序列化，保存到文件中的byte[]数组又可以“变回”Java对象，或者从网络上读取byte[]并把它“变回”Java对象。
         */

        /***序列化*/
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try(ObjectOutputStream output = new ObjectOutputStream(buffer)){
            //写入int
            output.write(12345);
            //写入string
            output.writeUTF("Hello");
            //写入object
            output.writeObject(Double.valueOf(123.456));
        }
        System.out.println(Arrays.toString(buffer.toByteArray()));
        //ObjectOutputStream既可以写入基本类型，如int，boolean，也可以写入String（以UTF-8编码），还可以写入实现了Serializable接口的Object。
        /**反序列化*/
        InputStream data = new ByteArrayInputStream(buffer.toByteArray());
        try(ObjectInputStream input = new ObjectInputStream(data)){
            System.out.println(input.readInt());
            System.out.println(input.readUTF());
            System.out.println((Double) input.readObject());
        }
    }
}
/*
小结

可序列化的Java对象必须实现java.io.Serializable接口，类似Serializable这样的空接口被称为“标记接口”（Marker Interface）；

反序列化时不调用构造方法，可设置serialVersionUID作为版本号（非必需）；

Java的序列化机制仅适用于Java，如果需要与其它语言交换数据，必须使用通用的序列化方法，例如JSON。
 */