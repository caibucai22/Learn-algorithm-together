package competition.sheng._2013;

/**
 * @author Csy
 * @Classname Main4
 * @date 2022-03-21 17:22
 * @Description TODO
 */
public class Main4 {

    public static void main(String[] args) {

        // 分析 这一行应该是不通分的处理
        // new rational(ra+x.ra,rb)

        Rational a = new Rational(1,1);
        Rational b = new Rational(1,2);

        Rational c = a.add(b);

        System.out.println(c);

    }

}

class Rational {
    private long ra;
    private long rb;

    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public Rational(long a, long b) {
        ra = a;
        rb = b;
        long k = gcd(ra, rb);
        if (k > 1) { //需要约分
            ra /= k;
            rb /= k;
        }
    }
    // 加法

    public Rational add(Rational x) {
        return new Rational(ra * x.rb + rb * x.ra, rb * x.rb);
    }
    // 乘法

    public Rational mul(Rational x) {
        return new Rational(ra * x.ra, rb * x.rb);
    }

    @Override
    public String toString() {
        if (rb == 1) return "" + ra;
        return ra + "/" + rb;
    }
}

