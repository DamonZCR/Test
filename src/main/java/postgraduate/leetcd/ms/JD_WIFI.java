package postgraduate.leetcd.ms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 20220429-京东-第二题
 * 题目描述:
 * Alice和Bob需要采购会议场馆内的无线路由器。每一种路由器有一个参数用于度量其通信距离。将场馆视为一个二维平面
 * 并将路由器视为该平面上的点，两台参数为的路由器只能在他们所在位置的曼哈顿距离不超过k的前提下直接通信。两个点
 * (x1.y1)和(x2,y2)之间的曼哈顿距离被定义为|x1-x2|+|y1-y2|.
 * 给出场馆内需要安装无线路由器的所有位置的坐标，请你计算出若他们只采购一种路由器，则其参数k至少需要为多少才能
 * 使得任意两个路由器之间都能够互相通信。
 * 能够互相通信的定义如下:存在一个路由器序列v1,v2....Vc，该序列中任意两个相邻路由器之间可以直接连接，则v1和vc之间可以互相通信。
 *
 * 输入描述
 * 第一行有一个正整数n(1<=n<=1000)，代表需要安装路由器的位置数量。
 * 第二行有n个整数，第i个代表编号为i的位置的x坐标。第三行有n个整数，第i个代表编号为i的位置的y坐标
 * 坐标的绝对值不超过1000000000。
 * 输出描述
 * 输出一个正整数，代表能够使得任意两个路由器在允许中继的前提下能够互相通信的参数的最小值。
 * 样例输入
 * 5
 * 0 1 1 3 4
 * 1 0 1 3 1
 * 样例输出
 * 3
 */
public class JD_WIFI {
    public static void main(String[] args) throws IOException {
        solve();
    }
    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] loca = new int[2][num];
        int res = Integer.MAX_VALUE;
        int leftx = Integer.MAX_VALUE;
        int rightx = Integer.MIN_VALUE;
        int lefty = Integer.MAX_VALUE;
        int righty = Integer.MIN_VALUE;
        for (int i = 0; i < 2; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < num; j++) {
                loca[i][j] = Integer.parseInt(s[j]);
                if (i == 0){
                        leftx = Math.min(loca[i][j], leftx);
                        rightx = Math.max(loca[i][j], rightx);
                }else {
                    lefty = Math.min(loca[i][j], lefty);
                    righty = Math.max(loca[i][j], righty);
                }
            }
        }
        int i = (leftx + rightx)/2;
        for (int j = (lefty + righty)/2; j <= righty; j++) {
            int min = Integer.MIN_VALUE;
            for (int k = 0; k < num; k++) {
                min = Math.max(min, Math.abs(i - loca[0][k]) +
                        Math.abs(j - loca[1][k]));
            }
            res = Math.min(min, res);
        }
        i = (leftx + rightx)/2;
        for (int j = (lefty + righty)/2 + 1; j <= righty; j++) {
            int min = Integer.MIN_VALUE;
            for (int k = 0; k < num; k++) {
                min = Math.max(min, Math.abs(i - loca[0][k]) +
                        Math.abs(j - loca[1][k]));
            }
            res = Math.min(min, res);
        }
        System.out.println(res);
    }
}
