package postgraduate.leetcd.ms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**360-2022-0319黑白反转
 * 题目描述:
 * 有n个黑白棋子，它们的一面是黑色，一面是白色。它们被排成一行，位置可以用标号1~n来表示。一开始，所有的棋子都是黑
 * 色向上，有q次操作，每次操作将位置标号在区间[L,R]内的所有棋子翻转(原来黑色变白色，原来白色变黑色)。请在每次操
 * 作后，求这n个棋子中，黑色向上的棋子个数。
 * 输入描述:
 * 第一行两个整数n，q,1 <= n <= 10^18, q<= 300;
 * 后面q行，每行两个整数L,R,1 <= L <= R <= n。
 * 输出描述:
 * q行，每行一个整数，表示每次操作后黑色向上的棋子个数.
 * 样例输入:
 * 100 2
 * 1 30
 * 21 40
 * 样例输出：
 * 70
 * 解题思路：
 * 1、看到区间修改，区间查询的题目应该直接想到线段树和树状数组。本题中的翻转操作可以转化为异或，
 * 初始全部为1（表示黑色棋子），翻转操作就是异或1。这样能够保证复杂度在nlogn。但本题中n太大，会爆内存所以肯定不是这种方法
 * 2、求区间内有多少的问题，考虑维护前缀和（这种方法我不会）
 * 3、同时考虑两次翻转的操作，不妨设输入为a,b,c,d且a<b<c<d。则有三种可能的情况，分别为[a.b],[c.d]、[a,c],[b,d]和[a,d],[b,c]；
 *   如图所示San60_HeiBaiFanZhuan.png，图中阴影部分是实际翻转的棋子。不难发现三种组合情况的最终结果相同。故得出结论，
 *   左端点为偶数的区间影响最终结果。
 *
 *    注意到特例[1,1],[2.2]（区间重合）的问题，左右端点相同对结果的贡献应当为1+1=2，而不是0。观察发现将左端点减一即可。
 *    将所有输入排序，取出奇数段的长度进行统计,偶数段比如就是中间bc段就是偶数段，不处理。
 */
public class San60_HeiBaiFanZhuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int q = sc.nextInt();
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < q; ++i) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            l = l - 1;
            list.add(l);
            list.add(r);
            Collections.sort(list);
            // 只有当所有的段都添加都数轴上时，才有用；
            long ans = n;
            int size = list.size();
            // 注意，只有当所有的区间都在数轴上才能用，因为如果只有a b
            // 去进行for没有价值,只有所有都在数轴，这时变换才可以；
            for (int j = 0; j < size - 1; ++j) {
                // 只取奇数段，比如a b 和 c d两端，中间的b c为偶数段；
                if (j % 2 == 0){
                    long tmp = list.get(j + 1)- list.get(j);
                    ans -= tmp;//减去中间个数的黑棋子；
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
