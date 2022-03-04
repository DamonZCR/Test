package postgraduate.studyJava.testFinal;
/*
*��final���������䲻������bufferָ���������󣬵�����bufferָ��Ķ���������ǿ��Ըı��
 */
public class finalVariable2 {
    public static void main(String[] args) {
        int i = 0;
        StringBuffer buffer = new StringBuffer("Hello");

        changeValue(buffer);
        System.out.println(buffer);//��� Hello World��
    }

    private static void changeValue(final StringBuffer buffer) {
        //buffer�Ѿ���final���Σ�����������ָ���������󣬵��Ƕ����������ǿ��Ը��ĵġ�ֻ�Ǹ������ݲ������¸�ֵ��
        //����final����ı����Ѿ��̶��ǳ�����һ�����ƣ�����final����ֻ�ܸ������ݡ�
        //buffer  = new StringBuffer("Hi");

        buffer.append(" World!");

    }

}
