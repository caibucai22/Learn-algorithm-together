import java.util.Arrays;

/**
 * @author Csy
 * @Classname LeetCode911
 * @date 2021-12-11 16:20
 * @Description TODO
 */
public class LeetCode911 {
    public static void main(String[] args) {
        int[] persons = {0,1,1,0,0,1,0};
        int[] times = {0,5,10,15,20,25,30};
        TopVotedCandidate1 solution = new TopVotedCandidate1(persons,times);

        int q = solution.q(8);
        System.out.println(q);
    }
}

/**
 * 正确解法
 */
class TopVotedCandidate {

    private int[] ticketsByPerson; // hash统计
    private int[] ret;
    private int maxTime;

    public TopVotedCandidate(int[] persons, int[] times) {

        maxTime = Arrays.stream(times).max().getAsInt();
        // 每个时间点的获胜者
        ret = new int[maxTime+1];
        ticketsByPerson = new int[times.length];

        int win = Integer.MIN_VALUE;
        int winIndex = -1;
        for(int i=0,j=0;i<=maxTime;i++){ // i是连续的时间，j是离散的时间数组times下标
            // 先把票投出去
            if(i==times[j]){ // 因为时间可能是离散的，只有在某些时间点才投了票，而不是每一个连续时间点都投了票
                int ticket = ticketsByPerson[persons[j]]++;
                if(ticket >= win){
                    win = ticket;
                    winIndex = persons[j];
                }
                j++;
            }
            ret[i] = winIndex;
        }

    }

    public int q(int t) {
        if(t>maxTime){
            return ret[ret.length-1];
        }
        return ret[t];
    }
}

/**
 * 这种具有时序性要求的，在更新的过程中，更新结果，而不是最后遍历得到目标结果，
 * 构造函数中，直接得到一个结果数组，调用q方法开销变小，而不是每次在q里面进行遍历得到结果
 */
class TopVotedCandidate1 {
    private int[] persons;
    private int[] times;
    private int[] ticketsByPerson; // hash统计

    public TopVotedCandidate1(int[] persons, int[] times) {
        // 遍历时间，把每一张票投给对应的人
        this.persons = persons;
        this.times = times;
        ticketsByPerson = new int[times.length];

        // 算出每一个时刻的胜利者

    }

    public int q(int t) {
        int win = Integer.MIN_VALUE;
        int winIndex = -1;
        for(int i=0,j=0;i<=t;i++){ // i是连续的时间，j是离散的时间数组times下标
            // 先把票投出去
            if(i==times[j]){ // 因为时间可能是离散的，只有在某些时间点才投了票，而不是每一个连续时间点都投了票
                int ticket = ticketsByPerson[persons[j]]++;
                if(ticket >= win){
                    win = ticket;
                    winIndex = persons[j];
                }
                j++;
            }
        }
        // 找到当前时刻的领先者
        // 这样出现无法保证时序性，是从头开始遍历的，若所有人都是相等的票，那么一定是最后一个编号输出
        // 而最后一个编号不一定是最新的投的哪一个

        // 不在这里面更新，而是在上面投票环节更新
        // for(int i=0;i<ticketsByPerson.length;i++){
        //     int ticket = ticketsByPerson[i];
        //     if(ticket >= win){
        //         win = ticket;
        //         winIndex = i;
        //     }
        // }
        return winIndex;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
