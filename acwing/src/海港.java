import java.io.*;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Csy
 * @Classname 海港
 * @date 2022-03-26 10:23
 * @Description TODO 滑动窗口
 * 计算窗口内的国家数目
 *
 *
 * 没写出来
 */
public class 海港 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(in.readLine().split(" ")[0]);
        String r = "";
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0; // 限制序列
        int i, j; // 在序列上遍历
        while (n-- > 0) {
            String st = in.readLine();
            r = r + st;
            end += st.length();
            char[] chs = r.toCharArray();
            for (i = start, j = 0; i < end; i++) {
                if(chs[i]==' ')continue;
                map.put(chs[i], map.getOrDefault(chs[i], 0) + 1);

                // 超过窗口大小 移动窗口
                if (i - j +1 > 86400) {
                    map.replace(chs[j], map.get(chs[j]) - 1);
                    j++;
                }

                // 统计国家数目
                if (i == end-1) {
                    long count = map.entrySet().stream().filter(o -> o.getValue() > 0).count();
                    out.write(String.valueOf(count));
                }
            }
            start += st.length();
        }

        in.close();
        out.flush();
        out.close();

    }

}
