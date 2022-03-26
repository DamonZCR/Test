package postgraduate.studyJava.studyStr;

/**
 * double和double的比较，已经float和float的比较；
 * 明明两个不相等的float类型，为什么比较出来是相等的？
 */
public class ChongXieEqualsFunc {
    public static void main(String[] args) {
        float a = 0.33455f;
        float a2 = 0.33454f;
        System.out.println(Float.floatToIntBits(a));
        System.out.println(a == a2);
        System.out.println(Float.floatToIntBits(a) == Float.floatToIntBits(a2));

        System.out.println("double 的比较");
        double b = 0.33455;
        double b2 = 0.33455;
        System.out.println(b == b2);
        System.out.println(Double.doubleToLongBits(b));
        System.out.println(Double.doubleToLongBits(2.00023434239f) == Double.doubleToLongBits(2.00023434233f));
        System.out.println(2.00023434239 - 2.00023434237 < 0.0000000001);


        System.out.println("--------测试float类型比较出错------");
        computer(2.00023434239f, 2.00023434233f);
        System.out.println("--------------------------------");
        computer(2.00023f,2.00022f);

    }
    public static void computer(float f1, float f2) {
        System.out.println("使用==比较结果：" + (f1 == f2));
        System.out.println("使用Math.abs() > 0比较：" + (Math.abs(f1 - f2) > 0));
        System.out.println("使用Math.abs() < 0比较：" + (Math.abs(f1 - f2) < 0));
        System.out.println("使用Math.abs() = 0比较：" + (Math.abs(f1 - f2) == 0));
        System.out.println("使用>比较：" + (f1 > f2));
        System.out.println("使用<比较：" + (f1 < f2));
    }
}
