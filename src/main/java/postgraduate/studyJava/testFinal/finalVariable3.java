package postgraduate.studyJava.testFinal;

public class finalVariable3 {
    public static void main(String[] args) {
        int i = 0;
        StringBuffer buffer = new StringBuffer("Hello");

        changeValue(buffer);
        System.out.println(buffer);//  Hello
    }

    private static void changeValue(StringBuffer buffer) {
        //ע��������������ββ�û���õ�����ʾ��ɫ��
        buffer  = new StringBuffer("Hi");
        buffer.append(" World!");
        System.out.println(buffer);//  Hi World!
    }
}
