package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LiuFangYun_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            StringBuilder lin = new StringBuilder(s[i]);

            res.append(lin.reverse());

            if (i != s.length - 1);
            res.append(" ");
        }
        System.out.println(res.toString());
    }
}
