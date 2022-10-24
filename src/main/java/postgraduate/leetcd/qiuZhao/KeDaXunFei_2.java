package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 科大讯飞20221009第二题
 *
 */
public class KeDaXunFei_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dis = Integer.parseInt(br.readLine());
        double cost = 0;
        int res = 0;
        if (dis <= 500){
            cost = dis / 100.0;
            res = (int) Math.ceil(cost * 60);
            System.out.println(res);
            return;
        }

        if (dis % 500 == 0) {
            int lin = dis / 500;
            res += lin * 300 + (lin - 1) * 5 + (lin - 1) * 50;
            System.out.println(res);
        }else {
            int lin = dis / 500;
            res += (lin - 1) * 50 + lin * 300 + calc(dis - lin * 500) + lin * 5;
            System.out.println(res);
        }
    }
    private static int calc(int dis){
        if (dis < 150){
            return (int)Math.ceil((dis / 10.0) + (dis / 100.0) * 60);
        }

        if (dis > 350){
            return (int)Math.ceil( (dis / 10.0) + (dis / 100.0) * 60 + 15 + 20);
        }
        return (int)Math.ceil(((dis - 150) / 20.0) + (dis / 100.0) * 60 + 15);
    }
}
