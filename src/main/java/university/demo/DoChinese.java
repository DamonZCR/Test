package university.demo;

import java.util.Arrays;

public class DoChinese {

    /*
     * 计算机是如何识别什么时候该把两个字节转换为一个中文呢?
     * 英文在计算机中以一个字节存储，识别为正数则翻译成英文字母，否则
     * 在计算机中中文的存储分两个字节：
     * 		第一个字节肯定是负数。
     * 		第二个字节常见的是负数，可能有正数。但是没影响。
     */

        public static void main(String[] args) {
             //String s = "abcde";
            // 结果：[97, 98, 99, 100, 101]

            String s = "我爱你中国";
            // [-50, -46, -80, -82, -60, -29, -42, -48, -71, -6]
            //eclipse默认的编码格式是GBK，而IDEA默认的编码格式是UTF-8（现已更改为GBK）

            byte[] bys = s.getBytes();

            //toString(byte[] a)返回指定数组内容的字符串表示形式。
            // 字符串表示形式由数组的元素列表组成，括在方括号（"[]"）中输出，(陈列出数组的所有元素)
            System.out.println(Arrays.toString(bys));
            System.out.println("通过使用平台的默认字符集解码指定的 byte 数组：");
            //解码得到。另：String构造方法还可以指定字符集编码，否则采用默认new String(bye,"UTF-8");
            System.out.println(new String(bys));
        }
    }

