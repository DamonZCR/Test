package postgraduate.studyJava.sort;

import java.util.Arrays;

public class MaoPao {
    public static void maoPao(int[] arr){
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j + 1] < arr[j]){
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        // System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int arr[] = {65,58,95,10,57,62,13,106,78,23,-1};
        System.out.println("排序前：" + Arrays.toString(arr));
        maoPao(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }
}
