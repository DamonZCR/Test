package postgraduate.studyJava.testExcept;

/**
 * 可以理解为finally执行后才能执行return，但是如果finally已经执行了return，所以其他(try中的)return也将失效;
 * 因为在FinallyAndReturn.java已经证明；
 */
public class FinallyAndReturn2 {
    public int add(int a, int b){
        try {
            return a + b;
        } catch (Exception e){
            System.out.println("--catch--");
        } finally {
            System.out.println("--finally--");
        }
        return 0;
    }

    public static void main(String[] args) {
        FinallyAndReturn2 flr2 = new FinallyAndReturn2();
        System.out.println(flr2.add(2, 3));
    }
}
