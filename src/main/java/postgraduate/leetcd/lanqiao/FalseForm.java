package postgraduate.leetcd.lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * 输入五个不同的数，这五个数有多少种方式可以实现：ab * cde = adb * ce
 */
public class FalseForm {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int res = solution1(split);
        System.out.println(res);
    }
    public static int solution1(String[] a){
        int num = 0;
        List<String> list = Arrays.asList(a);
        for (int one = 0;one < 5;one++){
            for (int two = 0;two < 5;two++){
                for (int thre = 0;thre < 5;thre++){
                    for (int four = 0;four < 5;four++){
                        for (int five = 0;five < 5;five++){
                            // ab * cde = adb * ce;
                            String ab = list.get(one) + list.get(two);
                            int ab1 = Integer.parseInt(ab);

                            String cde = list.get(thre) + list.get(four) + list.get(five);
                            int cde1 = Integer.parseInt(cde);

                            String adb = list.get(one) + list.get(four) + list.get(two);
                            int adb1 = Integer.parseInt(adb);

                            String ce = list.get(thre) + list.get(five);
                            int ce1 = Integer.parseInt(ce);

                            if(ab1 * cde1 == adb1 * ce1)
                                num++;
                        }
                    }
                }
            }
        }
        return num;
    }
}
