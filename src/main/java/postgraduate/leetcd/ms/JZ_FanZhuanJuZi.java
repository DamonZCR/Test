package postgraduate.leetcd.ms;

/** 20220426-金证科技-第一题；
 * 1.给定一个子(只包含字母和空格)，将句子中的单词位置反转，单词用空格分割,单词之间只有一个空格颇后没有空格。
 * 验入、的入取据有多组，每阻占一行，包含一个句子(句子长庭小于1000个字符)9出对子每个河试示例，要求输出句子中单词反转后形成的句子
 * 样例输入: hello kingdom l’m coming
 * 样例输出: coming l‘m kingdom hello
 */
public class JZ_FanZhuanJuZi {
    public static void main(String[] args) {
        String str = "hello kingdom l’m coming";
        String[] arrStr = str.split(" ");int length = arrStr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 1; i-- ) {
            sb.append( arrStr[i] + " ");
        }
        sb.append(arrStr[0]);//最后一个单词不加空格
        System.out.println(sb.toString());
    }
}
