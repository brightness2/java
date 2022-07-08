package conllection;

import java.util.Deque;
import java.util.LinkedList;

public class StackStudy {
    public static void run(){
        //栈（Stack）是一种后进先出（LIFO：Last In First Out）的数据结构。
        /*
        Stack只有入栈和出栈的操作：

    把元素压栈：push(E)；
    把栈顶的元素“弹出”：pop()；
    取栈顶元素但不弹出：peek()。
         */
        /*
        为什么Java的集合类没有单独的Stack接口呢？因为有个遗留类名字就叫Stack，出于兼容性考虑，所以没办法创建Stack接口，只能用Deque接口来“模拟”一个Stack了。

当我们把Deque作为Stack使用时，注意只调用push()/pop()/peek()方法，不要调用addFirst()/removeFirst()/peekFirst()方法，这样代码更加清晰。
         */
        Deque<String> stack = new LinkedList<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack.peek());//C
        System.out.println(stack.pop());//C
        System.out.println(stack.pop());//B
        System.out.println(stack.pop());//A
//        System.out.println(stack.pop());//空的栈，抛出NoSuchElementException异常
    }
}
