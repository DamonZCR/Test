package postgraduate.leetcd.ms;

import java.io.IOException;
;import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 小团最近在玩手机上的四川麻将。四川麻将的一种玩法是玩家摸完牌之 后选择三张花色一样的牌按
 * 某种顺序换给其他人。为了尽可能破坏对手的游戏体验，小团每次都会选择不连续的三张牌换出
 * 去。比如小团手上有14568这5张条子，则他可能会选择158这三张条子换出去。爱思考的小团马
 * 上对这个问题进行了推广。
 * 小团把这个问题进行了简化，现在他给了你一个可重集合， 并希望你从中选出一个尽可能大的子集
 * 使得其中没有两个数是“连续”的(连续是指即这两个数之差的绝对值不超过1)。
 *
 * 输入描述
 * 第行有一个整数n (1<=n<=100000)，代表小团给你的可重集大小。
 * 第二行有n个空格隔开的整数(范围在1到200000之间)，代表小团给你的可重集。
 * 输出描述
 * 输出满足条件的最大子集的大小。
 *
 * 样例输入
 * 6
 * 1 2 3 5 6 7
 * 样例输出
 * 4
 */
public class MT_KGePai {
    // 方法一
    public static void main(String[] args) throws IOException {
        int res = 1;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> num = new ArrayList<>(n);
        for (int i = 0; i< n;i++){
            num.add(sc.nextInt());
        }

        Collections.sort(num);
        int x = num.get(0);
        //对每一个元素进行判断，如果刚抽出的x+1，不等于当前遍历到的元素，
        //并且，x 不等于当前元素，说明可以将它抽取，因为不连续；
        for (int j = 1;j < n;j++){
            if (x + 1 != num.get(j) && x != num.get(j)){
                res++;
                x = num.get(j);
            }
        }
        System.out.println(res);
    }
    //方法二:原理与方法一相同。
    public static void solve2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr =  new int[n];
        for (int i = 0; i< n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(findNum(n, arr));
    }
    public static int findNum(int n, int[] arr){

        Arrays.sort(arr);
        int res = 1;
        int tmp = n-1;
        for (int i =n-2;i >=0;i--){
            if(arr[i]+1 != arr[tmp] && arr[i] != arr[tmp]){
                res++;
                tmp = i;
            }
        }
        return res;
    }
}
