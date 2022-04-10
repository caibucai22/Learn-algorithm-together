package course04;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description TODO
 * @Classname TestDeque02
 * @Created by Csy
 * @Date 2021/7/29 18:02
 */
public class TestDeque02 {

    public static void main(String[] args) {
        // 第二套api 出现异常返回特殊值
        // 添加操作
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);

        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);

        System.out.println(deque);

        // 删除操作
        deque.pollFirst();
        deque.pollLast();
        System.out.println(deque);

        // 取队首元素操作
        int first = deque.peekFirst();
        int last =  deque.peekLast();

        System.out.println(first+"  "+last);
    }
}
