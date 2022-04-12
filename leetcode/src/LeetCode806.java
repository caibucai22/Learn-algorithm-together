/**
 * @author Csy
 * @Classname LeetCode806
 * @date 2022-04-12 12:36
 * @Description TODO 写字符串需要的行数
 */
public class LeetCode806 {

    public static void main(String[] args) {
        int[] test = {7, 5, 4, 7, 10, 7, 9, 4, 8, 9, 6, 5, 4, 2, 3, 10, 9, 9, 3, 7, 5, 2, 9, 4, 8, 9};
        String s = "zlrovckbgjqofmdzqetflraziyvkvcxzahzuuveypqxmjbwrjvmpdxjuhqyktuwjvmbeswxuznumazgxvitdrzxmqzhaaudztgie";
        Solution806 solution = new Solution806();
        int[] ints = solution.numberOfLines(test, s);
        System.out.println(ints[0] + " " + ints[1]);
    }

}

class Solution806 {
    public int[] numberOfLines(int[] widths, String s) {
        int sum = 0;
        int row = 0;
        for (char ch : s.toCharArray()) {
            sum += widths[ch - 'a'];
            if (sum > 100) {
                sum = widths[ch - 'a'];
                row++;
            }
        }

        return new int[]{row + 1, sum};
    }
}
