package postgraduate.leetcd.ms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ALi_ {
    public static void main(String[] args) {
        //solve();
        List list = new ArrayList();
        list.add("1");
        list.add(2);
        list.add(2.4);
        double rs = (Integer)list.get(1)+(Integer)list.get(2);
        System.out.println(rs);
    }
    public static void solve(){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(s);
    }
}
