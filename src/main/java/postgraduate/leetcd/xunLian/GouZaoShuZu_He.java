package postgraduate.leetcd.xunLian;

import java.util.LinkedList;
import java.util.Scanner;

/** 分解数-和
 * 将一个数x分解为n个不同的数之和
 */
public class GouZaoShuZu_He {
    static int index = 0;
    LinkedList<Integer> link = new LinkedList<>();
    LinkedList<LinkedList<Integer>> result = new LinkedList<>();
    public static void main(String[] args) {
        solve();
    }
    public static void solve(){
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();//被分解的数
        int n = sc.nextInt();//分解为几个数；
        GouZaoShuZu_He wy = new GouZaoShuZu_He();

        wy.func(n, x, 0);
    }

    void print(LinkedList<Integer> link) {
        for (Integer it : link)
            System.out.print(it + " ");
        System.out.println("\n===============================");
    }
    void func(int n, int m, int min_el) {//把m 分解为n 个数相加；
        if (n == 2) {//如果是把 m 分解为 2个数的和
            for (int i = min_el + 1; i < m / 2; ++i) {
                link.offerLast(i);
                link.offerLast(m - i);
                result.offerLast(link);
                // 满足的情况就输出
                System.out.println("case:" + ++index);;
                print(link);
                link.pollLast();
                link.pollLast();
            }
            return;
        }
        for (int beg = min_el + 1; beg < m / n; ++beg) {
            link.offerLast(beg);

            func(n - 1, m - beg, beg);
            link.pollLast();
        }
    }
}
