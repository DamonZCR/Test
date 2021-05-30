package postgraduate.leetcd.lanqiao;
/**
 * 对于- -个整数，能整除这个整数的数称为这个数的约数。
 * 例如: 1,2,3, 6都是6的约数。
 * 请问78120有多少个约数。
 */
public class Java11A {
    public static void main(String[] args) {
        int a = 78120;
        int b = (int)Math.sqrt(a);
        //System.out.println(a%7);
        int i = 1;
        int num = 0;
        while(i < b){
            if (a%i == 0){
                num++;
            }
            i++;
        }
        System.out.println(num);
    }
}
