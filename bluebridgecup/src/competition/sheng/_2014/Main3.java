package competition.sheng._2014;

/**
 * @author Csy
 * @Classname Main3
 * @date 2022-03-22 16:30
 * @Description TODO
 */
public class Main3 {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 106; i++) {
            for (char ch = 'a'; ch <= 's'; ch++) {
                sb.append(ch);
            }
        }
//
//        while(sb.length() > 1){
//            for(int i=0;i<sb.length();i++){
//                if((i+1)%2 != 0){
//                    sb.deleteCharAt(i);
//                }
//            }
////            System.out.println(sb.length());
//            System.out.println(sb);
//        }
//
//        System.out.println(sb.toString());

        // 不能用stringbuffer  删除后 sb的下标发生了变化，

        char[] chs = sb.toString().toCharArray();
        System.out.println(chs);

        // abcdef
        // bdf
        int len = 2014;
        while(len > 1){
            int k = 0;
            for(int i=0;i<len;i++){
                if((i+1)%2 == 0){
                    chs[k++] = chs[i];
                }
            }
            for(int i=0;i<k;i++){
                System.out.print(chs[i]);
            }
            System.out.println();
            len = k;
        }

        // q
        // 总算整出来了，

    }


}
