package postgraduate.leetcd.huiWenMax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 解法1，暴力。
 * 利用双层for循环来遍历所有的子串情况，然后再在最里层循环中使用valid()方法判断该子字符串是不是
 * 回文的。复杂度为O(n^3);
 * 需要注意的是：subString(from，end)方法中,截取的子字符串不包括end位置的字符。
 */
public class BaoLi_1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        try{
            s = br.readLine();
        }catch (IOException e){
            System.out.println(e);
        }

        System.out.println(huiwen(s));
    }

    private static String huiwen(String s){
        if (s.length() <= 1)
            return s;
        String res = s.substring(0, 1);//首先以首单个字母作为最长回文。
        int len = s.length();
        int maxlen = 1;

        for (int i = 0;i < len;i++){
            for (int j = i + 1;j < len;j++){
                if (j - i + 1 > maxlen && valid(s, i, j)){
                    maxlen = j - i + 1;
                    if (j == len - 1)
                        res = s.substring(i);
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    private static boolean valid(String s, int from, int end){
        int nend = end;
        for (int i = from;i < nend;i++){
            if (s.charAt(i) != s.charAt(nend)){
                return false;
            }
            nend--;
        }
        return true;
    }
}
