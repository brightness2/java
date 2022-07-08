package conllection;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueStudy {
    public static void run(){
        /*
        队列（Queue）是一种经常使用的集合。Queue实际上是实现了一个先进先出（FIFO：First In First Out）的有序表
        Queue只有两个操作：
            把元素添加到队列末尾；
            从队列头部取出元素
         */
        /*
        在Java的标准库中，队列接口Queue定义了以下几个方法：

    int size()：获取队列长度；
	            throw Exception	  返回false或null
添加元素到队尾	add(E e)	      boolean offer(E e)
取队首元素并删除	E remove()	        E poll()
取队首元素但不删除	E element()	        E peek()

         */
        Queue<String> q = new LinkedList<>();
        q.offer("apple");
        q.offer("pear");
        q.offer("banana");

        System.out.println(q.peek());//apple
        System.out.println(q.peek());//apple

        System.out.println(q.poll());//apple
        System.out.println(q.poll());//pear
        System.out.println(q.poll());//banana
        System.out.println(q.poll());//null,因为队列是空的

        /*
        小结

        队列Queue实现了一个先进先出（FIFO）的数据结构：

            通过add()/offer()方法将元素添加到队尾；
            通过remove()/poll()从队首获取元素并删除；
            通过element()/peek()从队首获取元素但不删除。

        要避免把null添加到队列。
         */
    }

    public static void run2(){
            //有优先级的队列，即可以插队,priorityQueue
            Queue<String> q = new PriorityQueue<>();
            q.offer("apple");
            q.offer("pear");
            q.offer("banana");
        System.out.println(q.poll());//apple
        System.out.println(q.poll());//banana
        System.out.println(q.poll());//pear
        System.out.println(q.poll());//null
//        我们放入的顺序是"apple"、"pear"、"banana"，但是取出的顺序却是"apple"、"banana"、"pear"，这是因为从字符串的排序看，"apple"排在最前面，"pear"排在最后面。
//放入PriorityQueue的元素，必须实现Comparable接口

    }

    public static void run3(){
        //以银行排队业务为例,普通好A开头，vip以V开头,vip优先
        Queue<User> q = new PriorityQueue<>(new UserComparator());
        // 添加3个元素到队列:
        q.offer(new User("Bob", "A1"));
        q.offer(new User("Alice", "A2"));
        q.offer(new User("Boss", "V1"));
        q.offer(new User("Tom", "A10"));
        System.out.println(q.poll()); // Boss/V1
        System.out.println(q.poll()); // Bob/A1
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // null,因为队列为空
    }
}

class UserComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        if(o1.number.charAt(0) == o2.number.charAt(0)){
            // 如果两人的号都是A开头或者都是V开头,比较号的大小:
//            return o1.number.compareTo(o2.number);
            int num1 = Integer.parseInt(o1.number.substring(1));
            int num2 = Integer.parseInt(o2.number.substring(1));
            return num1 - num2;
        }
        if(o1.number.charAt(0) == 'V'){
            //号码是V开头,优先级高
            return -1;
        }else {
            return 1;
        }
    }
}

class User {
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
}