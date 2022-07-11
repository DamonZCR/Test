package postgraduate.leetcd.ms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 20220611-滴滴实习笔试第二题
 * 题目描述:
 * Bob有一个文本文件。因为新系统上的文本编辑器太难用了，Bob在其中进行查找和替换时只能纯人工操作。为了早点下班，
 * Bob决定找你开发一个查找和替换软件来降低他的工作量。现在他拿来了一些测试样例，你需要尽快写出一个能够通过这些样例的程序来交差。
 * 输入描述
 * 输入的第一行是一个由小写英文字母组成的字符串s。
 * 第二行有一个正整数n(1<=n<=100)，代表替换操作的次数。
 * 接下来n行每行有两个以空格隔开的由小写英文字母组成的字符串t1和t2，代表你的程序需要将S中每个t1从前到后逐个替换成t2。
 * 如s=abababa，t1=aba，t2=cc，则逐个替换
 * 的结果为abababa->ccbaba->ccbcc。s中第二个aba在第一次替换中被破坏，因此只有第一个和第三个aba才会被替换成cc。
 * 输入保证s的长度在任意一次替换前后均不会超过2000，且t1与t2的长度之和不超过100。
 * 输出描述
 *   输出s在n次替换操作后的结果。
 * 样例输入
 *   abcabc
 *   2
 *   bca cba
 *   bab aca
 * 样例输出
 *    acacac
 * 提示
 * 如样例: abcabc->acbabc->acacac。
 * 解题思路：
 *      使用KMP算法，找到可以匹配到的字符串的位置，然后进行替换；通过率87%；
 */
public class DD_ChaZhaoYuTiHuan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        //String s2 = br.readLine();
        //System.out.println(KMP(s,s2,getKMPNext(s2)));
        int fre = Integer.parseInt(br.readLine());
        String[][] s2 = new String[fre][2];
        for (int i = 0; i < fre; i++) {
            s2[i] = br.readLine().split(" ");
            //System.out.println(s2[i][0] + " " + s2[i][1]);
        }
        StringBuilder sb = null;
        for (int i = 0; i < fre; i++) {
            int loca = 0;
            String dest = s2[i][0];
            int[] kmpNext = getKMPNext(dest);
            sb = new StringBuilder(s);
            loca = KMP(s, dest, kmpNext);
            while (loca != -1){


                //sb.replace(loca - 1, loca + dest.length() - 1, s2[i][1]);
                sb.delete(loca - 1, loca + dest.length() - 1);
                sb.insert(loca - 1, s2[i][1]);
                s = sb.toString();
                loca = KMP(s, dest, kmpNext);
            }
        }
        System.out.println(s);
    }
    private static int KMP(String str, String dest, int[] next){
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (j > 0 && str.charAt(i) != dest.charAt(j)) j = next[j - 1];
            if (str.charAt(i) == dest.charAt(j)) j++;
            if (j ==  dest.length()) return i - j + 2;
        }
        return -1;
    }
    private static int[] getKMPNext(String str){
        int[] next = new int[str.length()];
        next[0] = 0;
        for (int i = 1,j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) j--;
            if (str.charAt(i) == str.charAt(j)) j++;
            next[i] = j;
        }
        return next;
    }
}
