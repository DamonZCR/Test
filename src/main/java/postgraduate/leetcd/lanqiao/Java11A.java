package postgraduate.leetcd.lanqiao;
/**
 * ����- -���������������������������Ϊ�������Լ����
 * ����: 1,2,3, 6����6��Լ����
 * ����78120�ж��ٸ�Լ����
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
