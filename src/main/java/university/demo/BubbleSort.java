package university.demo;

public class BubbleSort {
    //ð������
    public static void main(String[] args) {
        int t;
        int a[] = {8,89,69,3,65,56,55,78,};
        System.out.println("���鳤��Ϊ��"+a.length);
        for (int i = 0;i<a.length-1;i++){

            for (int j = 0;j< a.length-1-i;j++){
                if(a[j]>a[j+1]) {
                    t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
        }
        System.out.println("�����������С����Ϊ��");
        for(int x = 0;x<= a.length;x++){
            System.out.println(a[x]);
        }
    }
}
