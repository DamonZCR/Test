package postgraduate.studyJava.studyStr;

public class FindChinese {
    public static void main(String[] args) {
        // 方法一
        String regex = "[\u4e00-\u9fa5]";
        String ss = "java中求字符串中汉字的个数。";//中文汉字11个，标点1个。
        System.out.println(ss.split(regex).length - 1);//11

        //方法二

    }
}
