package postgraduate.leetcd.ms;

import java.util.Scanner;

/**小明的最大值-20220319京东
 * 题目描述:
 * 小明有一台机器，每次输入一个数就会返回一个非负整数。经过小明的多次试验，知道了如果给这台机器个数x，机器会
 * 返回这个数除以P的余数y(0 <= y < P,y属于 Z)，而P刻在这台机器的下方，小明可以查看到。
 * 例如当P=5时，输入x=9机器会返回4.输入15时会返回0,小明现在可以输入[L R]这个闭区司内所有的整数，
 * 问小明能从这台机器中得到的最大的返回值是多少。
 * 输入描述
 * 有多组数据。第一行一个数T表示数据组数
 * 接下来三行，每一行有T个整数L问.R间LP向，L问.R同LP向表示第组数据的区间左端点，右端点，和机器的参数P
 * 1 <=L <= R <= 100000, 0< P <= 100000 ,1 <= T <= 70000
 * 输出描述
 * 输出一行T个数按顺序分别表示每组数据的答案;
 *
 * 样例输入：
 * 2
 * 5 1
 * 6 2
 * 5 7
 * 样例输出：
 * 1 2
 */
public class JD_XiaoMingDeZuiDaZhi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] lr = new int[3][T];
        int[] res = new int[T];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < T; j++) {
                lr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < T; i++) {
            if (lr[0][i] >= lr[2][i] ||
                    (lr[0][i] <= lr[2][i] && lr[2][i] <= lr[1][i])) {
                // 区间范围大于P，
                if (lr[0][i] >= lr[2][i]){
                    // 大于两倍的P，就取P-1，否则就是r-1;
                    if (lr[1][i] >= 2 * lr[2][i])
                        res[i] = lr[2][i] - 1;
                    else
                        res[i] = lr[1][i] % lr[2][i];
                }else if(lr[0][i] == lr[2][i]){// 当p= 3,区间等于 3 - n时；
                    if (2 * lr[2][i] <= lr[1][i]){// 如果n就是大于等于6，那么肯定是3-1;
                        res[i] = lr[2][i] - 1;
                    }else
                        res[i] = lr[1][i] % lr[2][i];// 如果n小于6,就为右边界 模 3；
                }else{// p=3,区间时4-n时，
                    res[i] = lr[2][i] - 1;
                }
            }else{
                if (lr[1][i] == lr[2][i])
                    res[i] = lr[2][i];
                else
                    //范围小于P
                    res[i] = lr[1][i];
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
