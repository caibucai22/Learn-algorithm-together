package erverday._2022_06;

import java.util.Random;

/**
 * @author Csy
 * @Classname LeetCode478
 * @date 2022-06-07 17:03
 * @Description TODO
 */
public class LeetCode478 {
}

class Solution478 {
    double radius;
    double x_center;
    double y_center;
    Random rand;

    public Solution478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.rand = new Random();
    }

    public double[] randPoint() {
        while (true) {
            // x方向取一下 随机 y方向取一个随机
            double dx = rand.nextDouble() * (radius * 2) - radius;
            double dy = rand.nextDouble() * (radius * 2) - radius;

            if (dx * dx + dy * dy <= radius * radius)
                return new double[]{x_center + dx, y_center + dy};
        }

    }
}