package postgraduate.leetcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 小A正在制作糕点。这个糕点排成一排，分为了n个部分，从左到右每个部分依次1记(1.2...n)这些每个部分上初始都有一定的糖分， 对于部分i,糖分量记为ai 小A现在想给i 部分到第j部分再撒
 * 上些糖，最初的想法是撒b单位糖，但是她给第i部分撒了b单位的糖分后，就想给第i+ 1部分撒2b的糖分，给第i+ 2部分撒上3b的糖...最终给第j部分撒(j-i+ 1)*b单位的糖分，可以见得，小A还挺
 * 贪心的，想吃很多的糖。她一共撒了m次，每次都是这样的贪心，当她撒完后，想问问你最终这个糕点每个部分有多少的糖分。
 * 给定一个数列a2...;每次操作选择一个左端点和右端点j以及一个值b,对于任意正整数 k∈{i,i+1..j} ak +=(k-i+ 1)*b,操作m次后输出操作后的序列。由于答案可能很大，请模
 * 100000007后输出。(模指C中的%运算，A%B的数学意义为A除以B的余数)
 * 输入描述：
 * 第一行两个整数n和m,分别表示糕点大小和操作数；
 * 第二行n个整数，分别为a1，a2...,an;表示第i个部分的默认糖分。
 * 接下来m行，每行三个数i,j,b,分别表示此次操作的左端点，右端点，选定的值，意义如题面。
 * 1<=n,m,ai,b<=10^5, 1<=i<=j<=n
 * 输出描述：
 * 输出一行n个数，表示经过上述m次操作之后，依次从第1个部分到最后一个 部分糕点的糖分量模1000000007后的值。
 * 案例输入：
 * 5 3
 * 1 2 3 4 1
 * 1 3 1
 * 2 5 2
 * 3 3 6
 * 输出：
 * 2 6 16 10 9
 * 含义：
 * 第一次操作后序列变成
 * 1+1 2+2 3+3 4 1
 * 即
 * 2 4 6 4 1
 * 第二次操作后序列变成
 * 2 4+2 6+4 4+6 1+8
 * 即
 * 2 6 10 10 9
 * 第三次操作后序列变成
 * 2 6 10+6 10 9
 * 即
 * 2 6 16 10 9
 */
public class EatSurgar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String[] an = new String[n];
        an = br.readLine().split(" ");
        ArrayList<Integer> list = new ArrayList(an.length);
        for (String i:
             an) {
            list.add(Integer.parseInt(i));
        }
        ArrayList<String[]> list2 = new ArrayList(m);
        for (int i = 0;i < m; i++){
            String[] s = br.readLine().split(" ");
            list2.add(s);
            s = null;
        }

        for (int j = 0;j < m;j++){
            String[] arr = list2.get(j);
            int begin = Integer.parseInt(arr[0]) - 1;
            int end = Integer.parseInt(arr[1]) - 1;
            int value = Integer.parseInt(arr[2]);
            for (int t = begin; t <= end;t++){
                list.set(t, list.get(t) + (t - begin + 1) * value);
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext())
            System.out.print(it.next() + " ");
    }
}
