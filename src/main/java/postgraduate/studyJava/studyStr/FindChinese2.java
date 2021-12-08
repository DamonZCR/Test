package postgraduate.studyJava.studyStr;

import java.util.regex.Pattern;

/**
 * https://www.cnblogs.com/zztt/p/3427452.html
 * Java Character 实现Unicode字符集介绍  CJK中文字符和中文标点判断
 *
 * 主要内容：
 * 1. Java Character类介绍；
 * 2. Unicode 简介及 UnicodeBlock 与 UnicodeScript区别和联系
 * 3. 如何判断汉字及中文标点符号
 *
 * 做中文信息处理，经常会遇到如何判断一个字是否是中文，或者是否是中文的标点符号等。
 * 在Java中，主要使用 Character类处理字符有关功能，而JDK 1.7中Character是按照Unicode 6.0版本实现的，所以这个要先学习下常用的 Unicode编码。
 * 具体的定义、历史等请见 wikiwikipedia
 * Character 类中有3个静态内部类，
 * Modifier and Type	http://http://www.cnblogs.com/zztt/admin/EditPosts.aspx?opt=1www.cnblogs.com/zztt/admin/EditPosts.aspx?opt=1Class and Description
 * static class  	Character.Subset
 * Instances of this class represent particular subsets of the Unicode character set.
 * static class  	Character.UnicodeBlock
 * A family of character subsets representing the character blocks in the Unicode specification.
 * static class  	Character.UnicodeScript
 * A family of character subsets representing the character scripts defined in the Unicode Standard Annex #24: Script Names.
 * 其中的UnicodeBlock 和 UnicodeScript类可以帮助我们判断字符类型，
 * UnicodeBlock是Unicode标准协会组织unicode码的一个基本单位，实际上一个 UnicodeBlock代表一片连续的Unicode号码段，UnicodeBlock之间不重叠。例如，通常我们利用Unicode编码是否在 0x4E00–0x9FCC 来判断某字符是否为汉字，就是因为，有个UnicodeBlock 专门划分为存储汉字 (准确的说是 CJK统一汉字)，这个UnicodeBlock叫做 CJK Unified Ideographs，总共定义了 74,617 个汉字。
 * 当然还有其他很多UnicodeBlock，例如，对于汉字还有4个扩展 UnicodeBlock，CJK Unified Ideographs Extension A, B, C, D 分别都扩展了一些我们平时见都没见过的汉字(如果不是专门的古籍数字化，Unicode字符集中的汉字普通交流够了)
 * Unicode中一种Script通常就是一个字符或者其他书写符号的集合，代表着一种或多种writing systems （这里暂且翻译为文书类型，文书类型细分可以分成不同语言)。有些Script仅支持一种文字类型，有些可以支持多种，例如 Latin Script 支持 supports English, French, German, Italian, Vietnamese, Latin 等等，具体可见wikipedia，
 * http://en.wikipedia.org/wiki/Scripts_in_Unicode
 *
 */
public class FindChinese2 {
    public static void main(String[] args) {
        FindChinese2 classifier = new FindChinese2();
        String[] strings = new String[]{"Hello", "你好", "㐀㐂㐄", "にほんご", "조선어",",.?!@#$%^&()", "，。？！＠＃￥％……＆（）"};

        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            System.out.println("原字符串为：" + str);
            char[] chars = str.toCharArray();

            if (i < 5) {
                System.out.println("使用0x4E00-0x9FCC范围判断字符是否为汉字：");
                for (char aChar : chars) {
                    System.out.println(aChar + ":" + (classifier.isChineseByRange(String.valueOf(aChar)) ? "YES" : "NO"));
                }

                System.out.println("使用UnicodeBlock方法判断字符是否为汉字：");
                for (char aChar : chars) {
                    System.out.println(aChar + ":" + (classifier.isChineseByBlock(aChar) ? "YES" : "NO"));
                }

                System.out.println("使用UnicodeScript方法判断字符是否为汉字：");
                for (char aChar : chars) {
                    System.out.println(aChar + ":" + (classifier.isChineseByScript(aChar) ? "YES" : "NO"));
                }
            } else {
                System.out.println("判断是否为中文符号：");
                for (char aChar : chars) {
                    System.out.println(aChar + ":" + (classifier.isChinesePunctuation(aChar) ? "YES" : "NO"));
                }

            }
        }
    }

    //使用UnicodeBlock方法判断
    /**
     * UnicodeBlock 与 UnicodeScript 关系：
     * 所以UnicodeScript 是从语言书写规则层次对Unicode字符的分类，这是用使用角度划分，而UnicodeBlock是从硬的编码角度划分。
     * 1. UnicodeBlock是简单的数值范围 (其中可能有些Block中会有一些尚未分配字符的“空号”)。
     * 2. 在一个UnicodeScript中的字符可能分散在多个UnicodeBlock中；
     * 3. 一个UnicodeBlock中的字符可能会被划进多个UnicodeScript中。
     * 另外需要注意的是UnicodeScript实现是在Java 7中新引入的。
     * 具体在编写程序中，可以游2种办法，一是使用 UnicodeBlock，请见代码：
     *
     * @param c
     * @return
     */
    public boolean isChineseByBlock(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT) {
            return true;
        } else {
            return false;
        }
    }


    //使用UnicodeScript方法判断
    /**
     * 或者如果使用JDK1.7，那么UnicodeScript方法会更方便，因为UnicodeScript.HAN 包括了上面所列的5个UnicodeBlock：
     *
     * @param c
     * @return
     */
    public boolean isChineseByScript(char c) {
        Character.UnicodeScript sc = Character.UnicodeScript.of(c);
        if (sc == Character.UnicodeScript.HAN) {
            return true;
        }
        return false;
    }

    // 根据UnicodeBlock方法判断中文标点符号
    /**
     * 因为中文的标点符号主要存在于以下5个UnicodeBlock中，
     * U2000-General Punctuation (百分号，千分号，单引号，双引号等)
     * U3000-CJK Symbols and Punctuation ( 顿号，句号，书名号，〸，〹，〺 等；PS: 后面三个字符你知道什么意思吗？ : )    )
     * UFF00-Halfwidth and Fullwidth Forms ( 大于，小于，等于，括号，感叹号，加，减，冒号，分号等等)
     * UFE30-CJK Compatibility Forms  (主要是给竖写方式使用的括号，以及间断线﹉，波浪线﹌等)
     * UFE10-Vertical Forms (主要是一些竖着写的标点符号，    等等)
     *
     * @param c
     * @return
     */
    public boolean isChinesePunctuation(char c) {
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

    // 使用Unicode编码范围来判断汉字；这个方法不准确,因为还有很多汉字不在这个范围之内
    public boolean isChineseByRange(String str) {
        if (str == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("[\\u4E00-\\u9FCC]+");
        return pattern.matcher(str.trim()).find();
    }

}