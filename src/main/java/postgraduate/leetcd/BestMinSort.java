package postgraduate.leetcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*在一个数字队列变化游戏中，初始时玩家会得到一个有n个数字元素的队列，每个元素为...9中的一个。玩家每次可以从队列首部或者尾部取出一个数字，把它
放在新队列的尾部，重复此操作直到所有数字都被取出，新队列会组成一个n位的数字(可能包含先导0)。现在想知道对于每局游戏，你在规则允许的条件下能获
得的最小的数字是多少?
输入描述:
第一行一个正整数，数字个数n;
第二行n个数字，仅包含‘0’...‘9’，表示队列中从前到后的n个元素。
输出描述:
一个n位数字(可能包含先导0)，表示最小的结果国地
测试用例：
* 6
* 0 2 3 1 2 1
* 输出为12123
* 以下程序不完整，就是不正确。
* 如果输入4数据为2 1 9 2
输出为2219，应为2129.这个程序在遇到两个数相等的时候只考虑一味的取右边。正确应为考虑取了左边或右边并且在下一步或者下下一步也可以取到最小的。
 */
public class BestMinSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        String[] lens = br.readLine().split(" ");
        ArrayList<Integer> list = new ArrayList(lens.length);
        for (int i = 0;i<lens.length;i++) {
            list.add(Integer.parseInt(lens[i]));
        }
        int[] a = test(list);
        for (int i:a)
            System.out.print(i);
    }

    public static int[] test(ArrayList<Integer> list){
        int[] a = new int[list.size()];
        int q = 0;
        int h = 0;
        for(int i = 0;i<list.size();i++){
            if(list.get(q) < (list.get(list.size() - h - 1))){
                a[i] = list.get(q);
                q += 1;
            }
            else {
                a[i] = list.get(list.size() - h - 1);
                h += 1;
            }
        }
        return a;
    }
}
