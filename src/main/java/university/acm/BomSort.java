package university.acm;

/**
 * Created by Damon on 2019/3/18.
 */
public class BomSort {
    public static int[]a ={6,3,8,95,32,21};
    public static void main(String arg[]){
        sort(a);
        for (int x:a
        ){
        System.out.println(x);
        }
    }
    public static int[] sort(int[] x) {
        for (int i = 0; i < a.length-1; i++) {
            for(int j = 0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
        }
            return a;
    }
}