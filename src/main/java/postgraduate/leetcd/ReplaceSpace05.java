package postgraduate.leetcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * leetcode 第五题，将所有空格替换为%20.
 * replace 和 replaceAll 的区别
 * replaceAll支持正则表达式，因此会对参数进行解析（两个参数均是），如replaceAll("\\d", "*")
 * 而replace则不会，replace("\\d","*")就是替换"\\d"的字符串，而不会解析为正则。如果不使用正则表达式反而用了replaceAll,效率更低。
 */
public class ReplaceSpace05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(replaceSpace(s));
    }
    private static String replaceSpace(String s) {
        // 此处如果使用replaceAll() 效率将降低。
        String ss = s.replace(" ","%20");
        return ss;
    }
}
