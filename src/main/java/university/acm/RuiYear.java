package university.acm;
/*
����һ����ݣ��ж���һ���ǲ������ꡣ
���������֮һ����ʱ����һ�������꣺
1. �����4�ı���������100�ı�����
2. �����400�ı�����
��������ݶ��������ꡣ
ע��: ���ں�������������==
 */
import java.util.Scanner;

public class RuiYear {
    public static void main(String[] args) {
        int y;
        Scanner dc = new Scanner(System.in);
        y = dc.nextInt();
        if(((y % 100!=0) && (y % 4 == 0)) || y % 400 == 0){
            System.out.println("yes");
        }else
            System.out.println("no");
    }
}
