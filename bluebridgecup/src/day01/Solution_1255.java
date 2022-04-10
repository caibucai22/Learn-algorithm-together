package day01;

import java.util.*;

/**
 * @author Csy
 * @Classname Solution_1255
 * @date 2022-01-19 16:02
 * @Description 动态规划，理解错误
 */
public class Solution_1255 {

    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int ret = 0;
        int count = s.nextInt();
        int[] energy = new int[count];
        for (int i = 0; i < count; i++) {
            energy[i] = s.nextInt();
        }
//        // 从大到小排列
//        Arrays.sort(energy);

        // 顺序是给定的，不能从大到小排列

        for (int i = 1; i < count; i++) {
            Node node = new Node(energy[i-1],energy[i]);
            list.add(node);
        }
        Node last = new Node(energy[count-1],energy[0]);
        Node tmp = new Node(1,1);

        Iterator<Node> it = list.iterator();
//        ret += last
        while(it.hasNext()){

        }
    }
}

class Node {
    int front;
    int end;

    public Node(int front, int end) {
        this.front = front;
        this.end = end;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
