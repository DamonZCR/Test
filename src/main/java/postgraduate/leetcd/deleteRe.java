package postgraduate.leetcd;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

//数组去重
public class deleteRe {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 5, 5, 6, 4, 4};
        System.out.println(UseArray(a));
        UseSet(a);
    }
    //方法一，使用ArrayList进行包含判断。
    public static List<Integer> UseArray(int[] a) {
        ArrayList<Integer> b = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            if (!b.contains(a[i])) {
                b.add(a[i]);
            }
        }
        return b;
    }
    // 方法二，将数组加入到HashSet中
    public static void UseSet(int[] a){
        HashSet b = new HashSet(a.length);
        List<Integer> xx = Arrays.asList(ArrayUtils.toObject(a));
        b.addAll(xx);
        Iterator it = b.iterator();
        while (it.hasNext()){
            System.out.print(" " + it.next());
        }
    }
}