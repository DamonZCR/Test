package postgraduate.studyJava.studyStr;

/**
 * 用于检测字符串中中文汉字和中文字符个数
 */
public class FilterChinese {
    public static void main(String[] args) {
        FilterChinese fc = new FilterChinese();
        //String str = "英文符号5个:,.?!中文符号4个，。？！中文汉字14个";
        //String str = ",.?!，。？！";
        String str = "5555，。？！";
        int i = fc.chineCharNum(str);
        System.out.println(i);
    }

    public int chineCharNum(String str){
        char[] chars = str.toCharArray();
        int res = 0;
        for (char c : chars){
            if (isChinesePunctuation(c) || isChineseByScript(c))
                res++;
        }
        return res;
    }
    // 根据UnicodeBlock方法判断中文标点符号
    private boolean isChinesePunctuation(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS
                || ub == Character.UnicodeBlock.VERTICAL_FORMS) {
            return true;
        } else {
            return false;
        }
    }

    //使用UnicodeScript方法判断
    /**
     * 使用JDK1.7，那么UnicodeScript方法会更方便，因为UnicodeScript.HAN 包括了上面所列的5个UnicodeBlock：
     *
     * @param c
     * @return
     */
    private boolean isChineseByScript(char c) {
        Character.UnicodeScript sc = Character.UnicodeScript.of(c);
        if (sc == Character.UnicodeScript.HAN) {
            return true;
        }
        return false;
    }
}
