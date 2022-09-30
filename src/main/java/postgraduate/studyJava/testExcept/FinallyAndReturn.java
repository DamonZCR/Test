package postgraduate.studyJava.testExcept;
/** finaly
 * 	它是必须会被执行的，如果finally已经返回了结果，那么它也会覆盖掉；
 * 	第一次返回的 1，会被最后的执行的finally给覆盖掉为 0；
 */
public class FinallyAndReturn {
    public static void main(String[] args) {
        System.out.println(AFunc(5));
    }

    private static int AFunc(int a) {
        try{
            return 1;
        }catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            return 0;
        }
    }
}
