package university.recursion;

public class DiGuiTest {
    //测试构造方法是否可以递归调用

    public DiGuiTest(int a){
        System.out.println("a值为："+ a--);
        //if(a < 0) System.exit(0);
        //形成递归
        new DiGuiTest(a);
    }
    public static void main(String[] arg){
        new DiGuiTest(5);
    }
}
//如果不加If将造成死递归