package university.recursion;

public class DiGuiTest {
    //���Թ��췽���Ƿ���Եݹ����

    public DiGuiTest(int a){
        System.out.println("aֵΪ��"+ a--);
        //if(a < 0) System.exit(0);
        //�γɵݹ�
        new DiGuiTest(a);
    }
    public static void main(String[] arg){
        new DiGuiTest(5);
    }
}
//�������If��������ݹ�