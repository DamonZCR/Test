package postgraduate.leetcd.lanqiao;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [问题描述]
 * 对于一个字符串S，我们定义S的分值f(S)为S中恰好出现一次的字符个数。例如f("aba")= 1，f("abc")=3, f("aaa")=0。
 * 现在给定一个字符串S[0..n-1] (长度为n)，请你计算对于所有S的非空子串S[i..j](0≤ i ≤ j < n)，f(S[i..j)的和是多少。
 */
public class Java11ZiChuanFenZhiHe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solve(s));
    }

    /**
     * 运行超时；
     * @param s
     * @return
     */
    public static int solve(String s){
        int res = 0;
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb;
        int len = s.length();
        int lin = -1;
        List<String> collect;
        List<String> collect2;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                // substring(i, j)不包含第j个字符；
                lin = map.getOrDefault(s.substring(i, j + 1), -1);

                if (lin == -1){
                    if (i == j)//说明就一个字符；
                        res++;
                    else {
                        collect = Arrays.stream(s.substring(i, j + 1).split("")).sorted().collect(Collectors.toList());
                        lin = map.getOrDefault(collect.toString(), -1);

                        if (lin != -1){
                            res += lin;
                            continue;
                        }
                        lin = 0;
                        collect2 = Arrays.stream(s.substring(i, j + 1).split("")).distinct().collect(Collectors.toList());
                        for (int k = 0; k < collect2.size(); k++) {
                            if (Collections.frequency(collect, collect2.get(k)) == 1){
                                lin++;
                            }
                        }
                        map.put(collect.toString(), lin);
                        res += lin;
                        collect.clear();
                        collect2.clear();
                    }
                }else {
                    res += lin;
                }
            }
        }
        return res;
    }
}
