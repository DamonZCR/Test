package postgraduate.encry;
//���������
/*
* << ���������� >>����������,��߿ճ���λ��0��� >>> �޷�������,ע��Java����<<<�������
* ��λ���������Ժͣ��ϲ��������� <<= �� >>= �� >>>=������ a >>= 2; ��ʾ��a������λ���ֵ���¸���
*  >>���Ʋ���
*x>>y
*����x����2��y�˷�,ȡ����
*<<���Ʋ���
*X<<y
*����x����2��y�η�
 */
public class TestOperation {

    public static void main(String[] args) {
        System.out.println(2>>1);
        System.out.println(2<<2);
        int a = 4;
        System.out.println(a>>=1);

        byte b;
        char c;
        short d;
        b = 127;
        c = 127;
        d = 127;
        b <<=2;
        System.out.println("b <<=2�Ľ��Ϊ"+b);
        System.out.println(c <<=2);
        System.out.println(d <<=2);
    }
}
