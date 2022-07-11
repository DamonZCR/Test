package postgraduate.leetcd.ms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/** 20220611-滴滴实习笔试第一题
 * 题目描述:
 * 给出一个由正整数组成的序列。请判断能否将其中的每个数染成红色或蓝色，使得染成红色的教按顺序构成一个单调递增的序列，且染成蓝色的数按顺序构成一个单调递减的序列。
 * 输入描述
 * 第一行有一个正整数T(1<=T<=10)，代表测试数据的组数。
 * 每组测试数据的第一行有一个正整数n(1<=n<=500)，代表序列的长度。第二行有n个互不相同的范围在1到n之间的正整数，代表该序列。
 * 输出描述
 * 若可以按给出的规则染色，则输出Yes，否则输出No。
 * 样例输入
 3
 6
 3 6 5 1 4 2
 7
 7 4 1 3 2 5 6
 6
 1 4 3 6 5 2
 * 样例输出：
 * No
 * Yes
 * No
 * 提示
 * 如样例1中第二组，将1,2，5,6染成红色，7,4,3染成蓝色即是一个合法的染色方案。
 */
public class DD_XuLieChaiFen {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            int fre = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] nums = new int[fre];
            for (int j = 0; j < fre; j++) {
                nums[j] = Integer.parseInt(s[j]);
            }
            boolean re = dfs(nums, 0, new Stack<>(), new Stack<>() );
            if (re)
                res[i] = 1;
            else
                res[i] = 0;
        }

        for (int i = 0; i < num; i++) {
            if (res[i] == 0)
                System.out.println("No");
            else
                System.out.println("Yes");
        }
    }

    private static boolean dfs(int[] arr, int index, Stack<Integer> up, Stack<Integer> down) {

            if( arr.length == index)   return true;

            int num = arr[index];
            if( up.isEmpty() || num > up.peek() ){
                up.push( num );
            if( dfs( arr, index + 1, up, down) )
                return true;
                up.pop();
            }
            if( down.isEmpty() || num < down.peek() ){
                down.push( num );
            if( dfs( arr, index + 1, up, down) )
                return true;
                down.pop();
            }
            return false;
        }
}
