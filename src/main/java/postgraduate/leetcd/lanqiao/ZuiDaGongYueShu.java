package postgraduate.leetcd.lanqiao;

/**
 * 求最大公约数
 */
public class ZuiDaGongYueShu {
    public static void main(String[] args) {
        System.out.println(solve(2, 0));
    }
    public static int solve(int a, int b){
        return b == 0 ? a:solve(b, a% b);
    }
}
