package postgraduate.studyJava.testFinal;
/*
*ʹ��final�����βκ��β��ڷ����в��ɱ��ı䣬������ԭʵ�������Կɸı䡣
* ��Ҫ�Ƕ��ڻ������ͣ�Javaʵ�ֵ���ֵ���ݣ�ֻ�ǰ�ֵ�������βΡ�
* ��finalVariable2.java �������ݲ��ǻ������Ϳ��Ա����ĵ����ܱ��ض��塣
 */
public class finalVariable {
    public static void main(String[] args) {
        int i = 0;
        changeValue(i);
        i++;
        System.out.println(i);// 1
    }

    private static void changeValue(final int i) {
        //i++;  final����Ĳ������ɱ��ı䡣
        System.out.println(i);// 0
    }
}
