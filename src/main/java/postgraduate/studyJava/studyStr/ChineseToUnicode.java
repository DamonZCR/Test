package postgraduate.studyJava.studyStr;

/**
 * 测试将中文转为Unicode。
 */
public class ChineseToUnicode {
    public static void main(String[] args) {
        System.out.println(toUnicode("测试"));
    }

    public static String toUnicode(String s) {
        String as[] = new String[s.length()];
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            as[i] = Integer.toHexString(s.charAt(i) & 0xffff);
            s1 = s1 + "\\u" + as[i];
        }
        return s1;
    }
}
