package postgraduate.studyJava.testFinal;
/*
 *final����ı�������ͨ����������
 *����ʹ�÷�������final������ֵ�����Ƿ�����ֵֻ���������ڼ����֪������ֵ�ġ�
*/

public class VariableTest2 {
    public static void main(String[] args) {
        String a = "hello2";
        final String b = getHello();

        String c = b + 2;
        System.out.println(a == c);//false
    }
    public static String getHello(){
        return  "hello";
    }
}
