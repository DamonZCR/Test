package postgraduate.leetcd.ms;

import java.util.Scanner;

/**美团-20220319
 * 小美正在点外卖。外卖平台上有两种优惠机制:折扣和满咸。用户在下单的时候可以选择这两种机制中的一种。折扣机制即为部分商品提供了低于原价的优惠价，在结算的时
 * 候按优惠价计价。满减机制则由一些规则组成，每条规则都形如"满c元减d元”，意为若客户结算时所有商品的原价之和不低于c元，则客户可以减免d元。用户只能使用
 * 一条满减规则， 即若客户结算的商品总价为e元，使用了满c元减d元的规则且e不小于C,则用户只需要支付e-d元。
 * 小美有n种备选商品，每种商品均有原价和折扣价。 现在小美想知道，若仅购买前1.2.3..直到n种备选商品，是满减机制划算还是折扣机制划算。
 *
 * 输入描述
 * 第一行有一个正整数n(1<=n<=5000)，代表小美有n种备选商品。
 * 第二行有n个正整数，第i个数代表第i种备选商品的原价。商品的原价不会超过500。
 * 第三行有n个正整数，第i个数代表第i种备选商品的折扣价，折扣价不会高于商品的原价。
 * 第四行有一个正整数m(1<=n<=5000)，代表满减规则的数量。
 * 第五行有m个正整数，第i个代表第i条满减规则中的参数c(1<=C<= 000000)。
 * 第六行有m个正整数，第i个代表第i条满减规则中的参数d(1<=d<=c)。
 * 满减规则中的参数c按从小到大排列。数字间两两有空格隔开。
 * 输出描述
 * 输出一个长度为n的字符串，若仅购买前i种备选商品时满减机制更划算则第i个字符为M，若折扣机制更划算则第i个字符为Z，若两种机制带来的优惠相同则输出B。
 * 样例输入：
 * 3
 * 5 10 8
 * 5 8 7
 * 2
 * 15 22
 * 1 4
 * 输出：
 * BZM
 */
public class MT_DianWaiMai {
    public static void main(String[] args) {
        System.out.println(solve());
    }
    public static String solve(){
        Scanner sc = new Scanner(System.in);
        String res = "";
        int n =  sc.nextInt();
        int[][] shop = new int[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                shop[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[][] jian = new int[2][m];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < m; j++) {
                jian[i][j] = sc.nextInt();
            }
        }
        int price = 0;
        int JPirce1 = 0;
        int JPirce2 = 0;

        for (int i = 0; i < n; i++) {
            // 优惠
            price += shop[0][i];
            JPirce1 += shop[1][i];
            // 满减，想要进行满减，除非总价格大于等于第一个满减的
            JPirce2 = price;
            if (jian[0].length > 0 && price >= jian[0][0]){
                for (int j = 0; j < m && price >= jian[0][j]; j++) {
                    JPirce2 = Math.min(JPirce2, price - jian[1][j]);
                }
            }
            if (JPirce1 < JPirce2){
                res += "Z";
            }else if (JPirce1 == JPirce2){
                res += "B";
            }else
                res += "M";
        }
        return res;
    }
}
