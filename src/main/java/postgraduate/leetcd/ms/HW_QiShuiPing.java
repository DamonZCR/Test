package postgraduate.leetcd.ms;

import java.util.ArrayList;
import java.util.Scanner;

/** 华为-汽水瓶-笔试测试
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，
 * 她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，
 * 喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给
 * 你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽
 * 水瓶，最多可以换多少瓶汽水喝？
 *
 * 输入描述
 * 输入文件最多包含10组测试数据，每个数据占一行，仅包含一个正整数n（1<=n<=100），表示小张
 * 手上的空汽水瓶数。n=0表示输入结束，你的程序不应当处理这一行。
 * 输出描述
 * 对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
 *
 * 样例输入
 *  3
 *  10
 *  81
 *  0
 * 样例输出
 *  1
 *  5
 *  40
 */
public class HW_QiShuiPing {
    public static void main(String[] args) {
        solve();
    }
    public static void solve(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int flag = 1;
        int num = 0;
        while (flag == 1 || num != 0){
            num = sc.nextInt();
            if (num != 0)
                list.add(num);
            flag = 0;
        }
        // list.forEach(s-> System.out.print(s + " "));
        for (int i = 0; i < list.size(); i++) {
            // 对于每一个数量的瓶子进行计算；
            System.out.println(yinLiaoNum(list.get(i)));
        }
    }
    public static int yinLiaoNum(int num){
        int res = 0;
        int bottle = num;

        while (bottle > 1){
            if (bottle == 2){
                res++;
                break;
            }
            int how = bottle / 3;

            res += how;
            bottle = bottle - 2 * how;
        }
        return res;
    }
}
