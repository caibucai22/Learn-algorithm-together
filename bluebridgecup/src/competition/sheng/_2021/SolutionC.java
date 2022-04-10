package competition.sheng._2021;

import java.util.*;

/**
 * @author Csy
 * @Classname SolutionA
 * @date 2022-01-23 9:57
 * @Description TODO
 */
public class SolutionC {
    /**
     * 在平面直角坐标系中，两点可以确定一条直线。如果有多点在一条直线上，那么这些点中任意两点确定的直线是同一条。
     * ​ 给定平面上 2 × 3 2 × 32×3 个整点 ( x , y ) ∣ 0 ≤ x < 2 , 0 ≤ y < 3 , x ∈ Z , y ∈ Z {(x,y)|0 ≤ x < 2,0 ≤ y < 3, x ∈ Z,y ∈ Z}(x,y)∣0≤x<2,0≤y<3,x∈Z,y∈Z，即横坐标是 0 00 到 1 11 (包含 0 00 和 1 11) 之间的整数、纵坐标是 0 00 到 2 22 (包含 0 00 和 2 22) 之间的整数的点。这些点一共确定了 11 1111 条不同的直线。
     * ​ 给定平面上 20 × 21 20 × 2120×21 个整点 ( x , y ) ∣ 0 ≤ x < 20 , 0 ≤ y < 21 , x ∈ Z , y ∈ Z {(x,y)|0 ≤ x < 20,0 ≤ y < 21, x ∈ Z,y ∈ Z}(x,y)∣0≤x<20,0≤y<21,x∈Z,y∈Z，即横坐标是 0 00 到 19 1919 (包含 0 00 和 19 1919) 之间的整数、纵坐标是 0 00 到 20 2020 (包含 0 00 和 20 2020) 之间的整数的点。
     * 请问这些点一共确定了多少条不同的直线。
     *
     *
     * 答案 40257
     */

    public static void main(String[] args) {

        System.out.println(fierce(20, 21));

    }

    private static int fierce(int x, int y) {
        // 暴力破解法
        Node[] nodes = new Node[x * y];
        List<Node> nodeList = new ArrayList<>();
        Set<String> ks = new HashSet<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Node node = new Node(i, j);
                nodeList.add(node);
            }
        }
        for (int i = 0; i < nodeList.size() - 1; i++) {
            for (int j = i + 1; j < nodeList.size(); j++) {
                String k = Node.getKb(nodeList.get(i), nodeList.get(j));
                ks.add(k);
            }
        }
        return ks.size();
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static String getKb(Node a, Node b) {
        if ((b.x - a.x) == 0) {
            return "x=" + a.x;
        } else if ((b.y - a.y) == 0) {
            return "y=" + b.y;
        }
        // 最简单分数
        int up = b.y - a.y;
        int down = b.x - a.x;
        int gcd = gcd(up, down);
        String k = (up / gcd) + " " + (down / gcd);

        // b = y-kx;

        int up_kx = b.x * up;
        int up_y = b.y * down;

        int up_b = up_y - up_kx;
        // 此时的up_b结果是 乘了一个 down
        int div_b = gcd(up_b, down);
        String B = (up_b / div_b) + " " + (down / div_b);


        // + (down / div_b) 这个必须加上 否则不正确，但是有点理解不了

        return k + " " + B;

    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
