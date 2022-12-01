package postgraduate.studyJava.studyStr;

import java.util.regex.Pattern;
/**
 * 判断一个字符串是不是数字：
 * 三个判断属性：
 * 		方法一：判断是不是一个数字；
 * 		方法二：判断是不是一个整数；
 *      方法三：判断是不是一个小数；
 */
public class StrIsInt {
    //判断字符串是否是数字字符串(可以是正整数、0、负整数或者小数);
    public static boolean isNumber(String num){
        if (num == null || num.equals("")){//非空校验
            return false;
        }

        //数字校验（可以包含小数，可以是1，0，-1，1.1，-1.1，不可以是+1.1，+1）
        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
        //这个表示支持 +1.1，+1
        //Pattern pattern = Pattern.compile("[+-]?[0-9]+(\\\\.[0-9]+)?");
        if (!pattern.matcher(num).matches())
            return false;

        return true;
    }

    //判断字符串是否是纯数字，也就是数学上的整数(可以是正整数、0、负整数，不包含小数位）
    public static boolean isWholeNumber(String num){
        if (num == null || num.equals("")){//非空校验
            return false;
        }

        //整数校验（可以是+1，1，0，-1）
        Pattern pattern = Pattern.compile("[+-]?[0-9]+?");
        if (!pattern.matcher(num).matches())
            return false;

        return true;
    }
    //第三种:判断字符串是否是小数，小数点左边必须是整数(只有一个小数点，小数点左边是整数，右边至少包含一位数[0-9])。
    public static boolean isDecimal(String num){
        if (num == null || num.equals("")){//非空校验
            return false;
        }

        //小数校验（可以是+1.2，1.2，-1.2）
        Pattern pattern = Pattern.compile("[+-]?[0-9]+\\.([0-9]+)?");
        if (!pattern.matcher(num).matches())
            return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println("1.23 是否是数字 : " + isNumber("1.23"));
        System.out.println("+1.2/ 是否是数字 : " + isNumber("1.2/"));
        System.out.println("1 是否是数字 : " + isNumber("1"));
        System.out.println("+1 是否是数字 : " + isNumber("+1"));
        System.out.println("+1 是否是整数 : " + isWholeNumber("+1"));
        System.out.println("+1.23 是否是整数 : " + isWholeNumber("+1.23"));
        System.out.println("0 是否是整数 : " + isWholeNumber("0"));
        System.out.println("-9 是否是整数 : " + isWholeNumber("-9"));
        System.out.println("-9.3 是否是小数 : " + isDecimal("-9.3"));
        System.out.println("-9 是否是小数 : " + isDecimal("-9"));
        System.out.println("+9.3 是否是小数 : " + isDecimal("+9.3"));
        System.out.println("0 是否是小数 : " + isDecimal("0"));
    }
}
