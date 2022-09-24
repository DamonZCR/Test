package postgraduate.studyJava.testCollection.useSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DuoWeiArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> nums = new ArrayList<>();
        while (!sc.hasNext("\r\n")){
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            nums.add(new int[]{t1, t2});
        }
        Collections.sort(nums, (int[] a, int[] b) -> (a[0] - b[0]));
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i)[0] + " " + nums.get(i)[1]);
        }
    }
}
