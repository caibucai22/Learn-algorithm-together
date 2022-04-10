package course04;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description TODO
 * @Classname TestDeque
 * @Created by Csy
 * @Date 2021/7/29 17:53
 */
public class TestDeque {

    public static void main(String[] args) {
        // 第一套api 实现，出问题抛异常
        Deque<String> deque = new LinkedList<>();

        // 添加操作
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");

        System.out.println(deque);

        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");


        System.out.println(deque);

        // 删除操作
        deque.removeFirst();
        deque.removeLast();

        System.out.println(deque);

        // 队列两端
        String first = deque.getFirst();
        String last = deque.getLast();

        System.out.println(first+"  "+last);



    }
}
