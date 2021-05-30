package postgraduate.studyJava;

import org.junit.Test;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * 如何使用表示非常大的整数？  （蓝桥杯常考）
 * 如何实现这个整数的计算？
 * 测试案例：
 * ① test1 ：定义long。     实现如何定义 long 型的整数；范围是2^63-1
 *
 * BigInteger : 表示超大整数。整数取值范围原则上是没有上限的，取决于计算机的内存；一旦生成不可变；
 * BigInteger 多种构造方法，其中有 BigInteger("num",进制) 和 BigInteger("num")
 * 前者将字符串num 对应的进制转为数字，后者将 num 转为十进制的整数；
 * ② test2：生成。           生成BigInteger，分别有 控制台输入生成 和 构造方法生成；
 * ③ test3：乘除              实现两个大整数的乘multiply(BigInteger two)，不能简单是用 * ，除：divide(),使用BigInteger 提供的方法计算。
 *          加减               add(BigInteger two) 和 subtract(BigInteger two);
 *          取模 %              mod(BigInteger two) 需 参数为BigInteger类型 并且 大于 0，否则出现异常;
 *          求余 %              remainder(BigInteger two),注意：取模和求余只有在负数时结果不同。
 *          平方                one.pow(int two)，注意参数时 int 类型；
 *          绝对值              one.abs()
 *          相反数              one.negate()
 *          求商和余数          divideAndRemainder(BigInteger two) 返回一个BigInteger数组, [0]是a/b 的商， [1]是a%b 的余;
 *          判断素数            isProbablePrime(int two) 如果返回false，那么 一定 是合数。如果返回true可能是素数，概率和传入值有关;
 *          获取下一个素数       nextProbablePrime() 获取下一个素数,即大于a的下一个素数，返回是合数的概率为2的-100次方。还有有概率返回偶数的。
 *          自写开方（没有官方开方的方法）       JDK9 中才加入。
 *   test11  for循环
 *
 * ④ test4 : 比较             compareTo(BigInteger two)返回一个int型数据：1 大于； 0 等于； -1 小于；
 *           两数最大          max(BigInteger two)，min(BigInteger two)：分别返回大的（小的）那个BigInteger数据；
 *           两数最小
 * ⑤ test5 : 常量             BigInteger.ZERO；BigInteger.ONE；BigInteger.TEN 常量 0，1，10；
 * ⑥ test6 : 类型转换         将BigInteger数据转换成基本数据类型，还可以转换成radix进制的字符串形式；
 *           转为二进制补码    toByteArray(),输出时可能因为转型出错。
 *           转为字符串        toString()
 *           转为指定进制字符串  toString(int 进制)
 *           转为 int         intValue()
 *           转为 long        longValue()
 *           转为 float       floatValue()
 *           转为 double      doubleValue()
 * ⑦ test7： 二进制运算       返回值为BigInteger类型，此类方法不常用，有备无患
 *           与 a & b        and(two)
 *           或 a | b        or(two)
 *           异或 a ^ b       xor(two)
 *           取反 -a          not()
 *           左移 n 位 (a << n)    shiftLeft(int two)
 *           右移 n 位 (a >> n)    shiftRight(int two)
 * ⑧ test8 : 权限控制       setBit()，testBit()：可用于菜单的权限控制；
 *                          分装出一个BigInteger由2的次幂组合相加；
 *
 * ⑨ test9 ： long转BigInteger    使用valueOf()方法可以将一个Long类型的数字转换为BigInteger类型
 * ⑩
 * */
public class StuBigNum {

    @Test
    public void test1(){
        /**
         * long可以表示的数范围是：-9223372036854774808~9223372036854774807，（9的后面有18位数），即（-2的63次方到2的63次方-1）。
         * 定义long 的时候如果数大于int 所能表示的范围一定要加 L 或者 l；
         */
        // int 只能表示2147483647，约等于20亿,即 2^31 -1；
        long x = 2147483650L;
        long x2 = x * x; //如果是 x2 = x * x * x; 就会越界；
        System.out.println(x);
        System.out.println(x2); //4611686027017322500
    }
    @Test
    public void test2(){
        // 方法一：控制台输入一个BigInteger 整数；
        Scanner scan = new Scanner(System.in);
        BigInteger m = scan.nextBigInteger();
        System.out.println("控制台输入生成：" + m.toString());

        // 方法二：构造方法生成；
        BigInteger one = new BigInteger("1984546579835465649873546549876546546548711354698763228876");
        // 结果为：100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
        System.out.println(one);

        // 构造 其他进制的BigInteger;
        BigInteger two = new BigInteger("1000001010100010010101000111101010100001010101010000010000000000111110", 2);
        System.out.println(one.multiply(one));
    }

    @Test
    public void test3(){
        BigInteger one = new BigInteger("10000000000000000000000000000000000000000000000");
        BigInteger two = new BigInteger("55555555555555555555555555555555555555555555555");
        // 乘法
        // 结果为：100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
        System.out.println("乘法：" + one.multiply(one));

        // 除法
        System.out.println("除法：" + two.divide(one));// two / one = 5;

        // 加法
        System.out.println("加法：" + one.add(two));

        // 取模(需 参数为BigInteger类型 并且 大于 0，否则出现异常：ArithmeticException("BigInteger: modulus not positive"))
        System.out.println("取模：" + two.mod(one));

        // 求余
        System.out.println("求余：" + two.remainder(one));

        // 平方,参数 int类型。(需 参数 >= 0，否则出现异常：ArithmeticException("Negative exponent"))
        System.out.println("平方：" + one.pow(2));

        // 最大公约数
        System.out.println("最大公约数：" + one.gcd(two));

        // 绝对值
        System.out.println("绝对值：" + one.abs());

        // 相反数
        System.out.println("相反数：" + one.negate());

        // 求商和余数
        BigInteger[] num = two.divideAndRemainder(one); // 返回一个BigInteger数组，
        // num[0]是a/b的商，num[1]是a%b的余
        System.out.println(num[0]+" "+num[1]); // 1 0(商1，余0)

        // 判断是否是素数
        boolean probablePrime = one.isProbablePrime(1); // 如果返回false，那么一定是合数。如果返回true可能是素数，概率和传入值有关
        System.out.println(probablePrime);// false

        // 获取下一个素数，返回是合数的概率为2的-100次方。还有有概率返回偶数的。
        BigInteger b = one.nextProbablePrime(); // 返回大于a的下一个素数
        System.out.println(b); // 10000000000000000000000000000000000000000000121
    }
    @Test
    public void test4(){
        BigInteger one = new BigInteger("10000000000000000000000000000000000000000000000");
        BigInteger two = new BigInteger("55555555555555555555555555555555555555555555555");

        // 比较：返回一个int型数据（1 大于； 0 等于； -1 小于）
        System.out.println("比较：" + one.compareTo(two));// -1

        // 两数最大
        System.out.println("两数最大：" + one.max(two));

        // 两数最小
        System.out.println("两数最小：" + one.min(two));
    }
    @Test
    public void test5(){
        System.out.println("常量 0 ：" + BigInteger.ZERO);
        System.out.println("常量 1 ：" + BigInteger.ONE);
        System.out.println("常量 10 ：" + BigInteger.TEN);

        // valueOf(long two) 把一个long 型转为BigInteger;
        BigInteger two = BigInteger.valueOf(2147483648L);
        System.out.println("long 型转为BigInteger:" + two);
    }

    @Test
    public void test6(){
        BigInteger one = new BigInteger("8586989896564645454545");

        // 转为二进制补码.
        byte[] num = one.toByteArray();
        System.out.println("二进制补码(使用forEach输出)：" );
        for (byte b : num) {
            System.out.print(b + " ");
        }

        // 转为字符串
        System.out.println("\n转为字符串：" + one.toString());

        // 转为指定进制的字符串
        System.out.println("转为指定进制的字符串：" + one.toString(2));

        // 转为 int
        System.out.println("转为 int：" + one.intValue());// 1883199888

        // 转为 long,若使用：longValueExact()表示为：我们需要得到一个正确的结果并出现错误时抛出异常使用；
        System.out.println("转为 long：" + one.longValue());// 858698989656464

        // 转为 float
        System.out.println("转为 float：" + one.floatValue());// 8.5869899E14

        // 转为 double
        System.out.println("转为 double：" + one.doubleValue());// 8.58698989656464E14
    }

    @Test
    public void test7(){
        BigInteger one = new BigInteger("858698989656464");
        BigInteger two = new BigInteger("100000000000000");

        // 与 a & b
        System.out.println("两数相与 & ：" + one.and(two));// 9840042328064

        // 或 a | b
        System.out.println("或 a | b ：" + one.or(two));//948858947328400

        // 异或 a ^ b
        System.out.println("异或 a ^ b ：" + one.xor(two));//939018905000336

        // 取反 -a
        System.out.println("取反 -a ：" + one.not());//-858698989656465

        // 左移 n 位 (a << n), 参数为 int 型；
        System.out.println("左移 n 位 (a << n) ：" + one.shiftLeft(5));//27478367669006848

        // 右移 n 位 (a >> n), 参数为 int 型；
        System.out.println("右移 n 位 (a >> n) ：" + one.shiftRight(5));//26834343426764
    }

    @Test
    public void test8(){
        //1.封装数据(setBit的值需 >= 0，否则出现异常：ArithmeticException("Negative bit address"))
        BigInteger permission = new BigInteger("0");
        BigInteger numBig = permission.setBit(2);
        numBig = numBig.setBit(5);
        numBig = numBig.setBit(13);
        numBig = numBig.setBit(66);
        System.out.println("原理：" + numBig);
        // 原理：73786976294838214692 = 2^2+2^5+2^13+2^66 次方的和；
        // 看！！即使这么大的数也不会溢出，而int最大值只有2147483647；

        //2.取值验证（返回Boolean型）,验证此数是否被包含；
        boolean flag1 = numBig.testBit(2);		//true
        boolean flag2 = numBig.testBit(5);		//true
        boolean flag3 = numBig.testBit(13);		//true
        boolean flag4 = numBig.testBit(66);		//true
        boolean flag5 = numBig.testBit(27);		//false
    }
    @Test
    public void test9(){
        // valueOf(long two) 把一个long 型转为BigInteger;
        BigInteger two = BigInteger.valueOf(2147483648L);
        System.out.println("long 型转为BigInteger:" + two);
    }
    @Test
    public void test10(){
        // 计算BigInteger 开方；复杂度：O(nnlog(n))，7ms
        long startTime=System.currentTimeMillis();
        BigInteger n = new BigInteger("487897654321354");
        BigInteger a = BigInteger.ONE;
        BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
        while(b.compareTo(a) >= 0) {
            BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
            if(mid.multiply(mid).compareTo(n) > 0) b = mid.subtract(BigInteger.ONE);
            else a = mid.add(BigInteger.ONE);
        }
        System.out.println(a.subtract(BigInteger.ONE));
        System.out.println(a.subtract(BigInteger.ONE).multiply(a.subtract(BigInteger.ONE)));
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+" ms");
    }
    @Test
    public void test10_2(){
        // 计算BigInteger 开方；复杂度：  3ms
        BigInteger x = new BigInteger("9");
        // 初始一个 2^(x.bitLength()/2) 的数值。(近似于这个数的二进制长度的一半)
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
        BigInteger div2 = div;
        // 循环直到我们连续两次达到相同的值，或者交替结束。
        for(;;) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2)) {
                BigInteger res;
                if (y.equals(div))// 取最小；
                    res = y.min(div2);
                else
                    res = y.min(div);
                System.out.println(res);
                return;
            }
            div2 = div;
            div = y;
        }
    }
    @Test
    public void test11(){
        BigInteger end = new BigInteger("6");
        for(BigInteger i = BigInteger.ZERO; i.compareTo(end) < 0; i = i.add(BigInteger.ONE)){
            System.out.print(i + "  ");
        }
    }

    /**BigInteger 方法总结：
     * BigInteger abs()  返回大整数的绝对值
     * BigInteger add(BigInteger val) 返回两个大整数的和
     * BigInteger and(BigInteger val)  返回两个大整数的按位与的结果
     * BigInteger andNot(BigInteger val) 返回两个大整数与非的结果
     * BigInteger divide(BigInteger val)  返回两个大整数的商
     * double doubleValue()   返回大整数的double类型的值
     * float floatValue()   返回大整数的float类型的值
     * BigInteger gcd(BigInteger val)  返回大整数的最大公约数
     * int intValue() 返回大整数的整型值
     * long longValue() 返回大整数的long型值
     * BigInteger max(BigInteger val) 返回两个大整数的最大者
     * BigInteger min(BigInteger val) 返回两个大整数的最小者
     * BigInteger mod(BigInteger val) 用当前大整数对val求模
     * BigInteger multiply(BigInteger val) 返回两个大整数的积
     * BigInteger negate() 返回当前大整数的相反数
     * BigInteger not() 返回当前大整数的非
     * BigInteger or(BigInteger val) 返回两个大整数的按位或
     * BigInteger pow(int exponent) 返回当前大整数的exponent次方
     * BigInteger remainder(BigInteger val) 返回当前大整数除以val的余数
     * BigInteger leftShift(int n) 将当前大整数左移n位后返回
     * BigInteger rightShift(int n) 将当前大整数右移n位后返回
     * BigInteger subtract(BigInteger val)返回两个大整数相减的结果
     * byte[] toByteArray(BigInteger val)将大整数转换成二进制反码保存在byte数组中
     * String toString() 将当前大整数转换成十进制的字符串形式
     * BigInteger xor(BigInteger val) 返回两个大整数的异或
     */
}
