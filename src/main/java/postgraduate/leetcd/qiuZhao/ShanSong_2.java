package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**20220925闪送
 * 两个数组求差集；
 * 输入：[1,2,6];[-1,2,6]
 * 输入：[-1,1]
 */
public class ShanSong_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] split = s.split(";");
        String[] arr1 = split[0].substring(1, split[0].length() - 1).split(",");
        String[] arr2 = split[1].substring(1, split[1].length() - 1).split(",");

        List<String> list1 = Arrays.asList(arr1);
        ArrayList<String> list2 = new ArrayList<>(list1);
        ArrayList<String> list22 = new ArrayList<>(list2);

        List<String> list3 = Arrays.asList(arr2);
        ArrayList<String> list4 = new ArrayList<>(list3);
        ArrayList<String> list44 = new ArrayList<>(list4);


        list2.removeAll(list4);
        list44.removeAll(list22);
        ArrayList<Integer> res1 = new ArrayList<>();

        for (int i = 0; i < list2.size(); i++) {
            res1.add(Integer.parseInt(list2.get(i)));
        }
        for (int i = 0; i < list44.size(); i++) {
            res1.add(Integer.parseInt(list44.get(i)));
        }
        Collections.sort(res1);
        System.out.print("[");
        for (int i = 0; i < res1.size(); i++) {
            System.out.print(res1.get(i));
            if (i != res1.size() - 1)
                System.out.print(",");
        }
        System.out.println("]");
    }
}
