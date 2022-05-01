package postgraduate.leetcd.ms;

import java.util.Scanner;

/** 华为-20220420-第一题
 * 小聪入职新公司，参加线上的新员工必备考试,考试共25题,依次是10个判断题(每题2分)、10个单选题(每题4分)和5个多选题(每题8分),总分100分。
 * 考题只能顺序作答，答对题目获得相应的分数，答错题日获得0分，考试系统不提示作答是否正确,答题过程中如果累积有3题答错，直接中止考试并计算考试分数。
 * 小聪考试结果是N分(O<=N<=100)，请根据小聪的分数,算出所有可能的答题情况的个数。
 *
 * 输入
 * 整数,表示小聪的考试得分N,N为偶数，0<=N<=100(N不会是不可能考出来的分数)。
 * 输出
 * 整数表示所有可能的答题情况的个数
 * 样例1
 * 输入:94
 * 输出:100
 * 解释:有1道判断题和1道单选题答错,其余的题都答对,所有可能的答题
 * 情况的个数为100。
 * 样例2
 * 输入:100
 * 输出:1
 * 解释:所有题目全部答对,答题情况的个数为1.
 */
public class HW_XiaoCongZuoTi {
    static int res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 2;
        while(score > 1){
            score = sc.nextInt();
            res = 0;
            dfs(1, 0, 0,score);
            System.out.println(res) ;
        }
    }

    public static void dfs(int num, int errorCount,int score,int sum){
        if(score == sum){
            res++;
            return;
        }
        if(errorCount == 3 || num > 25) return;
        if(1 <= num && num <= 10){
            dfs(num+1, errorCount, score + 2, sum);
            dfs(num+1,errorCount + 1,score, sum);
        }else if(11<= num && num<= 20){
            dfs(num+1, errorCount,score + 4,sum);
            dfs(num+1,errorCount + 1, score, sum);
        }else {
            dfs(num+1, errorCount,score + 8, sum);
            dfs(num+1, errorCount + 1,score,sum);
        }
    }
}
