package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 题目描述:
 * 小X在一片大陆上探险，有一天他发现了一个洞六,洞穴里面有n道门
 * 打开每道门都需要对应的钥匙,编号为i的钥匙能用于打开第i道门,而且只有在打开了第i(i>=1)道门之后，才能打开第i+1道门,
 * 一开始只能打开第1道门。幸运的是,小X在外面探索的途中，每天都能发现一把能打开这n道门中其中一道门的钥匙,每天找完钥匙
 * 后他都会去打开所有能打开的门。现在给出他每天找到的钥匙编号，请问每道门分别在哪一天被打开。
 *
 * 输入描述
 * 第一行包含一个正教数n，表示门的数星。
 * 接下来一行包含n个正整数a,a2,..., an,其中aj表示第i天他找到的钥匙的编号,能够打开第ai道门,数据保证a1-an,为1-n的一个排列。
 * 输出描述
 * 输出一行n个数s1,S2,....,Sn,其中nS表示第i道门在第Si大被打开；
 *
 * 输入案例：
 * 5
 * 5 3 1 2 4
 * 样例输出：
 * 3 4 4 5 5
 * 提示
 * 数据范围和说明
 * 1<= n<=1ooooo
 * 洋例说明
 * 到第三天时获得的钥匙为1、3、5,能够打开第1道门,到第四天时为1、2、3、5,能能继续打开第2
 * 和3道门到第五天时获得了全部钥匙,能打开所有剩下的门。
 */
public class S360_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>(line);
        int loca = 0;
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < line; i++) {
            list.add(Integer.parseInt(s[i]));
        }
        loca = list.indexOf(1);
        int[] res = new int[line];
        res[0] = loca;
        boolean[] flag = new boolean[line];
        for (int i = 0; i < loca; i++) {
            flag[i] = true;
        }
        for (int i = 2; i < line + 1; i++) {
            int index = list.indexOf(i);
            if (flag[index]){
                res[i - 1] = loca;
            }else {
                loca = index;
                res[i - 1] = loca;
                for (int j = 0; j <= index; j++) {
                    if (!flag[j])
                        flag[j] = true;
                }
            }
        }
        for (int i = 0; i < line; i++) {
            System.out.print(res[i] + 1);
            if (i != line - 1)
                System.out.print(" ");
        }
    }
}
