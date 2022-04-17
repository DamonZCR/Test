package postgraduate.leetcd.ms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**20220414-便利蜂笔试-第一题
 * 便利蜂商品购买问题2
 * 题目描述:
 * 便利蜂的商店售卖着琳琅满目的商品，吸引着小蜂来到便利蜂商店想购买一些商品解解馋。小蜂特别喜欢便利蜂的蜂质选产品、不眠海饮品和关东煮。
 * 小蜂想购买一款蜂质选产品、一杯不眠海饮品、一份关东煮,并且总花费不能超过x元,小蜂想知道自己有多少种购买方案。
 * 编入描述
 * 第一行输入n个数字，每两个数字用空格隔开，每个数字p代表蜂质选产品的价格
 * 第二行输入m个数字，每两个数字用空格隔开,每个数字p代表不眠海饮品的价格
 * 第三行输入k个数字,每两个数字用空格隔开，每个数字p代表关东煮的价格
 * 第四行输入一个数字，计为x，表示小蜂口袋里的钱
 * 数据范围:
 * 1 <= n，m,k <=10000
 * 1 <= p<= 10000
 * 1<=x<=3*10000
 * 输出描述
 * 输出一个数字,表示小蜂购买方案数。
 * 注意:答案需要以1e9+7(1000000007)为底进行取模，如:计算结果为1000000008，就输出1;如果没有一种方案可以同时购买3种商品,则输出-1;
 * 样例输入
 * 1 2
 * 3 4
 * 5 6
 * 10
 * 样例输出
 * 4
 * 提示
 * 小蜂一共有4种购买方案
 * 方案1:1（蜂质选)+3(不眠海）+5(关东煮)=9<10
 * 方案2∶1(蜂质选)+3(不眠海)+6(关东煮)= 10 <= 10
 * 方案3:1(蜂质选） +4(不眠海）+5(关东煮)= 10 <= 10
 * 方案4:2(蜂质选)+3(不眠海)+5(关东煮)= 10<= 10
 * 样例二:
 * 输入:
 * 1 2
 * 3 4
 * 5 6
 * 5
 * 输出:
 * -1
 * 提示:小蜂无法同时购买三件商品花费最少的组合:1+3 + 5=9 >5
 */
public class BLF_GouMaiShangPinBuChaoX {
    public static void main(String[] args) throws IOException {
        solve2();
    }
    /**
     * 解法一：
     * 直接暴力解题，使用三层for循环；通过率为54%；
     */
    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        String[] s3 = br.readLine().split(" ");
        int len1 = s1.length, len2 = s2.length, len3 = s3.length;
        int x = Integer.parseInt(br.readLine());
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < len1; i++) {
            list1.add(Integer.parseInt(s1[i]));
        }
        for (int i = 0; i < len2; i++) {
            list2.add(Integer.parseInt(s2[i]));
        }
        for (int i = 0; i < len3; i++) {
            list3.add(Integer.parseInt(s3[i]));
        }

        Collections.sort(list3);
        long res = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            if (list1.get(i) >= x)
                continue;
            for (int j = 0; j < len2; j++) {
                if (list1.get(i) + list2.get(j) >= x)
                    continue;
                for (int k = 0; k < len3; k++) {
                    int value = list1.get(i) + list2.get(j) + list3.get(k);
                    if (value <= x){
                        String lin = list1.get(i) +"-"+ list2.get(j) + "-"+ list3.get(k);
                        if (map.getOrDefault(lin,0) != 1){
                            res++;
                            map.put(lin, 1);
                        }
                    }else
                        break;
                }
            }
        }
        System.out.println(res % 1000000007);
    }

    /**
     * 解法二：
     * 两层for循环，第三层for循环使用二分查找优化。复杂度优化为n^2*logn;
     * 通过率为65%；
     */
    public static void solve2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        String[] s3 = br.readLine().split(" ");
        int len1 = s1.length, len2 = s2.length, len3 = s3.length;
        int x = Integer.parseInt(br.readLine());
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < len1; i++) {
            list1.add(Integer.parseInt(s1[i]));
        }
        for (int i = 0; i < len2; i++) {
            list2.add(Integer.parseInt(s2[i]));
        }
        for (int i = 0; i < len3; i++) {
            list3.add(Integer.parseInt(s3[i]));
        }

        Collections.sort(list3);
        long res = 0;
        for (int i = 0; i < len1; i++) {
            if (list1.get(i) >= x)
                continue;
            for (int j = 0; j < len2; j++) {
                if (list1.get(i) + list2.get(j) >= x)
                    continue;
                int value = list1.get(i) + list2.get(j);
                // 因为对第三个list3排序，所有如果发现加上某一个位置w的价格后，
                //三个产品的总价值大于等于x,在w+1的位置上大于了x,那么说明满足的第三个产品的个数为0 - w个；
                int xx = midFind(list3, value, x);
                if (xx != -1){
                    res += xx + 1;
                }
            }
        }
        System.out.println(res % 1000000007);
    }
    public static int midFind(ArrayList<Integer> list, int lin, int x){
        int left = 0;
        int right = list.size() - 1;
         int loca = 0;
        while (left <= right){
            int mid = (right + left) / 2;
            if (list.get(mid) + lin > x){
                right = mid - 1;
            }else {
                left = mid + 1;
                loca = mid;
            }
        }
        if (lin + list.get(loca) <= x)
            return loca;
        return -1;
    }
}
