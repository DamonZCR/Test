package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/** 海能达-20220926
 * 牛牛家里有一个计算器。
 * 牛牛不小心把自己的计算器玩坏了。乘法（×）和除法（÷）按钮全都失灵。
 * 所以，牛牛决定以后用它来计算只含加(+)和减(-)的表达式。
 * 最近，牛牛突然发现，这个计算器的幂（^）按钮变成了异或键！本来 5^2=25 的，现在 5^2=7 了。
 * 因此他想知道，输入一个表达式后计算器会返回多少。
 * 该计算器认为优先级异或（^）>加（+），减（-）。
 * 输入描述
 * 输入一串表达式，保证该字符串只含数字，+，-，^，且每个数字 <= 1000000
 * 输出描述
 * 输出答案。
 * 输入样例
 * 3+5^2-9
 * 1
 * 输出样例
 * 1
 */
public class HaiNengDa_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int i = 0;
        int j = 0;
        Stack<Long> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        while (i < line.length()){
            while (j < line.length() && (line.charAt(j) >= '0' && line.charAt(j) <= '9')){
                j++;
            }
            st1.add(Long.valueOf(line.substring(i, j)));
            if (st2.size() > 0){
                Character peek = st2.pop();
                if (peek == '^'){
                    long a = st1.pop();
                    long b = st1.pop();
                    st1.push(a ^ b);
                } else if (st1.size() > 1){
                    long a = st1.pop();
                    long b = st1.pop();
                    if (peek == '-'){
                        st1.push(b - a);
                    }else {
                        st1.push(b + a);
                    }
                }
            }
            if (j < line.length()){
                st2.add(line.charAt(j));
            }
            j++;
            i = j;
        }
        System.out.println(st1.pop());
    }
}
