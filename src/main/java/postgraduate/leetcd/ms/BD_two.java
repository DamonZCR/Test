package postgraduate.leetcd.ms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**百度笔试-20220412-第二题
 * 九月，小镇新开了一家商品店。依依决定从明天开始每天去那家店,通过每天购买一件商品来收集商店中的所有商品。
 * 值得注意的是小镇新开的店只有依依才会去光顾，所以不会有人去买商品。
 * 已知店里经营N件商品,第i件商品的价格是Ai元。但是商品每一天都会增加Bi元,换句话说，在开业后的第d天购买
 * 产品i需要Ai＋Bi * d元.依依初次购买的那天是开业后的第0天。
 * 此外,每件商品只有一件存货,所以依依不能两次都购买相同的商品。为了回报依依的光顾,店主决定每当奇数天(开业第1,3,5...….2*n＋1)
 * 天开展促销活动。依依可以选择自己喜欢的产品,无论价格如何,将免费领取一件。
 * 因此,依依想让你帮他设计种购买商品的顺序,并以尽可能少的钱收集商店中的所有产品。
 * 请你编写一个程序，购买N件商品,最小花费为多少。
 * 输入描述:
 * 第一行输入一个正整数N。
 * 随后N行,每行给出两个整数A, B
 * 1 <= N ≤ 2000
 * 1<= Ai, Bi <= 10^5
 * 输出描述:
 * 输出购买N件商品,最小花费为多少。
 * 示例1输入输出示例仅供调试,后台判题数据一般不包含示例
 * 输入
 * 3
 * 6 8
 * 2 9
 * 4 7
 * 输出
 * 13
 * 说明
 * 第0天:2+9 * 0 =2 支付两元购买商品2;
 * 第1天:4+7 * 1=11，支付11元购买商品 3;
 * 因为是奇数天，所以可以免费领取商品1;
 *
 * 示例2
 * 输入
 * 2
 * 6 2
 * 3 3
 * 输出
 * 11
 * 说明
 * 第0天购买商品2，第一天购买商品1。总共花费11元。
 */
public class BD_two {
    public static void main(String[] args) throws IOException {
        sovle();
    }
    public static void sovle() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] ab = new int[N][2];
        int res = 0;
        boolean[] used = new boolean[N];
        for (int i = 0; i < N; i++) {
            used[i] = false;
            String[] s = br.readLine().split(" ");
            ab[i][0] = Integer.parseInt(s[0]);
            ab[i][1] = Integer.parseInt(s[1]);
        }

        int date = 0;
        int flag = 0;
        while (true){
            date++;
            int index = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                if (!used[i]){//还未被使用
                    if (min > ab[i][0]){
                        min = ab[i][0];
                        index = i;
                    }
                }
            }
            res += min;
            used[index] = true;
            flag++;
            for (int i = 0; i < N; i++) {
                if (!used[i]){//还未被使用
                    ab[i][0] = ab[i][0] + ab[i][1] * date;
                }
            }
            if (flag == N)
                break;
        }
        System.out.println(res);
    }
}
