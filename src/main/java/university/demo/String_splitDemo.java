package university.demo;
//�ַ����ָ��split������
/*Java�У���ĳ���ַ��ָ��ַ���ʹ�õ���String�����split()���������ص��Ƿָ�֮���String���飬
        ֵ��ע����Ƿָ�������ָ���� . ������ | ʱ������ʹ�� \\ ����ת�塣*/
public class String_splitDemo {
    public static void main(String[] args) {
        String s = "al_f|f.ggl|oil_.k|";//���һ���ָ���գ���û�м�¼
        String[] splituse = s.split("\\|");
        for (String string:splituse){
            System.out.println(string);
        }
    }
}