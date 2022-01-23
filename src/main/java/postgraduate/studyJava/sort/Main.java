package postgraduate.studyJava.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] br = input.readLine().split(" ");
        int[] num = new int[br.length];
        for (int i = 0;i<br.length;i++) {
            num[i] = Integer.parseInt(br[i]);
        }
        BucketSort test = new BucketSort();
        test.bucketSort(num);
        for (int a:num
             ) {
            System.out.println(a);

        }
    }
}

