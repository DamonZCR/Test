package postgraduate.studyJava;

public class TestException {
    public static void main(String[] args) {
        try{
            int x = 4;
            int y = 4 + 1;
            int z = 4 / 0;
        }catch(Exception e){
            System.out.println("捕捉异常，执行catch()");
            //System.exit(0);
            return;
        }finally {
            System.out.println("进入finally 输出！");
        }
    }
}
