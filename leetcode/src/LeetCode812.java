/**
 * @author Csy
 * @Classname LeetCode812
 * @date 2022-05-15 13:57
 * @Description TODO
 */
public class LeetCode812 {

    public static void main(String[] args) {

    }

}


class Solution812 {
    public double largestTriangleArea(int[][] points) {
        // 暴力
        double ret = 0.0;
        int n = points.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                for(int k=0;k<j;k++){
                    double area = getArea(points[i],points[j],points[k]);

                    ret = Math.max(area,ret);
                }
            }
        }
        return ret;
    }

    private double getArea(int[] a,int[] b,int[] c){
        double e1 = getEdge(a,b);
        double e2 = getEdge(a,c);
        double e3 = getEdge(b,c);
        // System.out.println(e1+" "+e2+" "+e3);
        double ave = (e1+e2+e3)*0.5;
        Double area = Math.sqrt(ave*(ave-e1)*(ave-e2)*(ave-e3));
        return area.isNaN() ? 0 : area;
    }

    private double getEdge(int[] a,int[] b){
        return Math.sqrt(Math.pow(a[0]-b[0],2) + Math.pow(a[1]-b[1],2));
    }
}