package postgraduate.leetcd.xunLian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 牛牛是一家广告公司的员工，-天的工作很固定，就是将k条新的广告，按照注册用户所设定的时间顺序发放到用户的邮箱。由于牛牛近期自学了编程的相关知识，他知道，
 * 如此重复性的工作，可以交给程序来自动完成。但是，牛牛只学习了相关语法，并不会如此高级的操作，于是，牛牛将用户信息交给了你，希望你能帮帮他。
 * 牛牛会告诉你，每一个用户所设定的时间，如果某用户设定的时间为t,那么，这位用户接收第一封广 告的时刻为t，接收第二封广告的时刻为2*t,接收第三封广告的时刻为3*t...以此类推。
 * 输入描述:
 * 第一行输入两个正整数n，k ( 1<= n<=k<=106)依次代表用户数量，以及今天需要发放的广告数量。
 * 第2到第n+1行，每行一个正整数t(1<≈t<≈1000)，其中，第i+ 1行输入的正整数，代表编号为i的用户，所设定的时间t
 * 输出描述:
 * 输出一共k行，按照发放广告的时间顺序，依次输出用户的标号，特殊的，如果某一个时间，有多个用户可以接受广告，则优先给编号小的发放。
 * 输入：
 * 3 3
 * 3
 * 6
 * 9
 * 输出
 * 1
 * 1
 * 2
 */
public class SendAdvers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lens = br.readLine().split(" ");
        int[] num = new int[lens.length];
        for (int i = 0; i < lens.length; i++) {
            num[i] = Integer.parseInt(lens[i]);
        }
        ArrayList<Integer> list = new ArrayList<>(num[0]);
        for(int j = 0;j< num[0];j++){
            list.add(Integer.parseInt(br.readLine()));
        }
        List<Integer> test1 = test2(list, num[1]);
        Iterator<Integer> iterator = test1.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next()+1);
        }
    }
    public static List<Integer> test2(ArrayList<Integer> list, int k){
        List<Integer> newlist = Arrays.asList(new Integer[list.size()]);
        Collections.copy(newlist, list);
        int n = 0, num1 = 0;
        ArrayList<Integer> list1 = new ArrayList(k);

        while(n < k){
            num1++;
            if (list.indexOf(num1) != -1){
                int lin  =  list.indexOf(num1);
                list1.add(lin);
                list.remove(lin);
                list.add(lin, (Collections.frequency(list1, lin)+1) * newlist.get(lin));
                n++;
                if ((Collections.frequency(list1, num1) != 1) && n < k){
                    int lin2 = 0;
                    while (((lin2 = list.subList(lin+1, list.size() - 1).indexOf(num1)) !=-1 )&& n < k){
                        list1.add(lin2 + lin+1);
                        list.remove(lin+ lin+1);
                        list.add(lin2+ lin+1, (Collections.frequency(list1, lin2+ lin+1)+1) * newlist.get(lin));
                        n++;
                        lin = lin2;
                    }
                }
            }
        }
        return list1;
    }
}
