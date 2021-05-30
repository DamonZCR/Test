package university.acm;

/**
 * Created by Damon on 2019/3/18.
 */

//—°‘Ò≈≈–Ú

public class ChooseSort {
    public static int[]a ={6,3,8,95,32,21};
    public static void main(String arg[]){

        sort(a);

        for (int x:a
        ){
            System.out.println(x);
        }
    }

    private static int[] sort(int[] a) {
        int k;
        for(int i=0;i<a.length-1;i++){
            k=i;
            for(int j=i+1;j<=a.length-1;j++){
                if(a[j]<a[i]) k=j;
                if(k!=i){
                    int t=a[i];
                    a[i]=a[k];
                    a[k]=t;
                }
            }
        }
        return a;
    }
}
