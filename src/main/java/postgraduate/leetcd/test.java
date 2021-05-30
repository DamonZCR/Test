package postgraduate.leetcd;


import org.junit.Test;

public class test {
    public static void main(String[] args) {

    }
    @Test
    public void testMath(){
        // 左移代表 乘以 2 的多少次方。
        int n = 2;
        System.out.println(n<<3);
        System.out.println(n*(Math.pow(2, 3)));

        // Java中向上取整 和 向下取整。
        double a = 30;
        double b = 20;
        double c = a / b;
        System.out.println(c);
        System.out.println("向上取整：" + Math.ceil(c));
        System.out.println("向下取整：" + Math.floor(c));
    }
}