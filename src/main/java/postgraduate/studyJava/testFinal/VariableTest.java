package postgraduate.studyJava.testFinal;
/*
*final����ı�������ͨ����������
*���ڱ���b��final���Σ���˻ᱻ����������������������ʹ�õ� b�ĵط���ֱ�ӽ�����b �滻Ϊ����ֵ��
* �����ڱ���d�ķ���ȴ��Ҫ������ʱͨ�����������С�����ʱ���Ϊa �� e �Ƚ�ʱe���Ǵ���c �ĵ�ַ�ģ�
 */
public class VariableTest {
    public static void main(String[] args) {
        String a = "hello2";
        final String b = "hello";
        String c = "hello";

        String d = b + 2;
        String e = c + 2;
        System.out.println(a == d);//true
        System.out.println(e);//hello2
        System.out.println(a == e);//false
    }
}
