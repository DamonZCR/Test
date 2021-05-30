package postgraduate.leetcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

/**
 * 小美得到了一款游戏斗龙。 小美拥有两个技能，每个技能都能秒杀掉一条龙， 但是要付出相
 * 应的MP值，第一个技能需要c 1点MP值，第二个技能需要c2点MP值。只要MP足够，小美可以使
 * 用无限次技能。
 * 小美即将遇到n条龙，如果不使用技能，她和第i条龙的战斗结果是T或者F，而如果使用任何一
 * 个技能战斗结果都是T。T表示小美成功打败龙，而F表示小美被龙打败。如果小美被龙连续打败三
 * 次，那小美就会输掉游戏。请你帮忙计算小美最少需要多少点MP才能通关。
 * 输入描述
 *      第一行三个数n,c1,c2。(1 sns 100000，1≤c1,c2≤000000000)。
 *      第二行n个字符，第i个字符si代表小美与第i场战斗的结果。si 是T代表小美打败龙，si是F代表小美被龙打败。
 * 输出描述
 *      输出一个数，代表小美最少需要的MP值。
 *样例输入
 *  10 7 3
 *  FTFFFTFFFF
 *样例输出
 *  6
 */
public class BattleKong {
    public static void main(String[] args) throws IOException {
        int[] one = new int[3];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lens = br.readLine().split(" ");
        for(int i=0;i<3;i++)
            one[i] = Integer.parseInt(lens[i]);
        String[] two = br.readLine().split("");
        int lin = Math.min(one[1], one[2]);
        System.out.println(test(two, lin));

    }
    public static int test(String[] m, int c){
        int first = 0;
        int res = 0;
        int num = 0;
        int length = m.length;
        while (first < length){
            if(m[first].equals("T")){
                res += c * (num/3);
                num = 0;
            }else{
                num++;
            }
            first++;
        }
        if(m[m.length-1].equals("F"))
            res += 3;
        return res;
    }
}
