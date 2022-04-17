package postgraduate.leetcd.ms;

import java.util.LinkedList;
import java.util.Scanner;

/** 网易-20220416-第二题
 * 构造一个长度为n的数组，要求：
 * 1、最大值不大于k；
 * 2、不存在重复元素；
 * 3、数组的和为x;
 */
public class WY_GouZaoShuZu2 {
    LinkedList<Integer> link = new LinkedList<>();
    LinkedList<LinkedList<Integer>> result = new LinkedList<>();
    public static void main(String[] args) {
        solve();
    }
    public static void solve(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();//分解为几个数；
        int k = sc.nextInt();//最大不超过k
        int x = sc.nextInt();//被分解的数,也就是和为x;
        WY_GouZaoShuZu2 wy = new WY_GouZaoShuZu2();

        wy.func(n, x, 0, k);
    }

    void print(LinkedList<Integer> link, int k)
    {
        int max = 0;
        for (Integer it : link){
            max = Math.max(it, max);
        }
        if (max <= k){
            for (Integer it : link){
                System.out.print(it + " ");
            }
            System.exit(0);
        }
    }
    void func(int n, int m, int min_el, int k)
    {
        if (n == 2)
        {
            for (int i = min_el + 1; i < m / 2; ++i)
            {
                link.offerLast(i);
                link.offerLast(m-i);
                result.offerLast(link);
                print(link, k);
                link.pollLast();
                link.pollLast();
            }
            return;
        }
        for (int beg = min_el + 1; beg < m / n; ++beg)
        {
            link.offerLast(beg);
            func(n - 1, m - beg, beg, k);
            link.pollLast();
        }
    }
}
