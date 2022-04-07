package postgraduate.leetcd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/** 440. 字典序的第K小数字-困难
 * 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 *
 * 示例 1:
 * 输入: n = 13, k = 2
 * 输出: 10
 * 解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 *
 * 示例 2:
 * 输入: n = 1, k = 1
 * 输出: 1
 */
public class ZiDianXuDiKXiaoShuZi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(findKthNumber(n, k));
    }

    public static int findKthNumber(int n, int k){
        /**
         * 29 / 69 个通过测试用例
         * 状态：超出时间限制
         * 提交时间：1 分钟前
         * 最后执行的输入：
         * 4289384
         * 1922239
         */
        if (n < 10 && k <= n){
            return k;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        // 将所有的数据加入进去；
        int num = 0;
        ArrayList<Integer> integers = null;
        for (int i = 1; i <= n; i++) {
            num = Integer.parseInt(String.valueOf(String.valueOf(i).charAt(0)));
            //不可以直接将数字加到List的后面，需要判断；
            insertNum(map.get(num), i);
        }
        int len = 0;
        num = 0;
        int i = 1;
        for (; i < 10; i++) {
            num = len;
            len += map.get(i).size();
            if (len >= k)
                break;
        }
        return map.get(i).get(k - num - 1);
    }
    public static void insertNum(ArrayList<Integer> list, int num){
        int len = list.size();
        String theNums = String.valueOf(num);
        String point = null;

        for (int i = 0; i < len; i++) {
            point =  String.valueOf(list.get(i));
            int newNum = Integer.parseInt(theNums.substring(0, point.length()));
            if (newNum < list.get(i)){
                list.add(i, num);
                return;
            }
        }
        list.add(num);
    }
}
