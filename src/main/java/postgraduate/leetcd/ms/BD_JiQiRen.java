package postgraduate.leetcd.ms;

import java.util.Scanner;

/**百度笔试-20220412-第一题
 * 牛妹买了一个遥控机器人，遥控器上有4种指令:
 * 1.L:机器人向左走一步
 * 2.R:机器人向右走一步
 * 3.U:机器人向上走一步
 * 4.D:机器人向下走一步
 * 可以把地面看出是一个二维平面,向上为y轴坐标增大的方向，向右为a坐标增大的方向。
 * 机器人一开始在(0,0）处，每移动一步的距离就是坐标轴上一个单位的距离。
 * 先给出牛妹的操作指令，问机器人最后的坐标是什么?
 * 输入描述:
 * 输入一行字符串s，仅包含'L’，'R'，'U'，‘D'四种字
 * 输出描述:
 * 以(x, y)的形式输出机器人最后的坐标
 * 示例1
 * 输入：R
 * 输出:(1,0)
 * 示例2：
 * 输入：RU
 * 输出：(1,1)
 */
public class BD_JiQiRen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;
        String str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'L')
                x -= 1;
            else if (str.charAt(i) == 'R')
                x += 1;
            else if (str.charAt(i) == 'U')
                y += 1;
            else
                y -= 1;
        }
        System.out.println("(" +x + "," + y+")" );
    }
    public static void solve(){

    }
}
