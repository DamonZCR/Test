package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** 六方云
 * 两个集合求交集，并排序输出前五个；
 */
public class LiuFangYun_2 {
    public static void main(String[] args) throws IOException {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            list1.add(Integer.parseInt(s[i]));
        }
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < s2.length; i++) {
            list2.add(Integer.parseInt(s2[i]));
        }

        list1.retainAll(list2);
        Collections.sort(list1);//从小到大升序
        //Collections.reverse(list1);
        for (int i = 0; i < 5; i++) {
            System.out.print(list1.get(i) + " ");
        }
    }
}
