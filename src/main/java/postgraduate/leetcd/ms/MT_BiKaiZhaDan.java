package postgraduate.leetcd.ms;

import java.util.HashSet;

/**避开炸弹-美团20220312笔试；
 *题目描述:
 * 小美现在打音游。这个音游的玩法是这样的:
 * 一共有n个房间。 小美初始拥有一个指针，指在一号房间。
 * ----游戏共持续m秒， 每秒会有一个房间产生炸弹，小美的指针不能在这个房间中。
 * ----每秒结束的瞬间，小美可以使用一次魔法，把指针切换到另-个房间中，该过程会消耗一个能量，
 * 你的任务是计算小美无伤通过音游所需要消耗的最小能量。
 * 保证第-秒的炸弹不发生在一号房间中。
 */
public class MT_BiKaiZhaDan {
    public static void main(String[] args) {
        System.out.println(zhaodao(2, new int[]{2, 1, 1,2}));
    }
    public static int zhaodao(int n, int[] m){
        int len = m.length;
        int room = 1;
        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        /**
         * 第一层for循环是用来遍历每一秒的，如2 1 1 2；当第一秒的时候，在第一个位置，此时2号房间爆炸，因为
         * 在默认在1号房间所以没事；于是第一层for循环判断if就不会进去；
         * 当i等于1的时候，第二秒1号房间爆炸，此时需要环房间，进入if，因为m[1] == room，等于现在所处的房间号，
         * 所以此时肯定需要换房间于是，能量值++；
         * 第二层循环就是用来找到，从i位置开始，n个房间中最后一个发生爆炸的房间号，然后进去；
         * 为什么找n个房间中最后一个发生爆炸的？因为，可以更少的换房间；
         * 怎么实现？如有2 4 4 2 1 2 3，n= 4个房间，我使用set集合依次装了2 4 1 后，当装了最后一个3，发现3号房间是
         * 最后一个装的房间，所以我如果第一次跳到3号房间，是不是就在0-5的区间中只需要跳一次就行；
         */
        for(int i = 0; i < len;i++ ) {
            if(m[i] == room ) {
                result++;
                // 找到最后出现的房间号，也就是最后使set集合加上这个房间号后，set的size等于房间总数的房间数；
                for(int j=i; j<len;j++) {
                    if(!set.contains(m[j])){
                        set.add(m[j]);
                    }
                    // 找到这个房间
                    if(set.size() == n) {
                        room = m[j];
                        set.clear();
                        break;
                    }
                }
                if(room == m[i]) {
                    return result;
                }
            }
        }
        return result;
    }
}
