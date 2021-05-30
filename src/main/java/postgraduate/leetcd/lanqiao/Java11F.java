package postgraduate.leetcd.lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * 小蓝给学生们组织了一-场考试，卷面总分为100分，每个学生的得分都是
 * .一个0到100的整数。
 * 如果得分至少是60分，则称为及格。如果得分至少为85分，则称为优秀。
 * 请计算及格率和优秀率，用百分数表示，百分号前的部分四舍五入保留整
 * 数。
 * [输入格式]
 * 输入的第一-行包含一个整数n,表示考试人数。
 * 接下来n行，每行包含一个0至100的整数，表示- 一个学生的得分。
 * [输出格式]
 * 输出两行，每行一一个百分数，分别表示及格率和优秀率。百分号前的部分
 * 四舍五入保留整数。
 */
public class Java11F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int value = 0;
        int jige = 0, you = 0;
        for (int i = 0;i < n;i++) {
            value = Integer.parseInt(br.readLine());
            if(value >= 60){
                jige++;
                if(value >= 85)
                    you++;
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");
        String[] first = df.format((float)jige/n).split("");
        String[] second = df.format((float)you/n).split("");

        System.out.println(Integer.parseInt(first[2])*10 + Integer.parseInt(first[3]) + "%");
        System.out.println(Integer.parseInt(second[2])*10 + Integer.parseInt(second[3]) + "%");
    }
}
