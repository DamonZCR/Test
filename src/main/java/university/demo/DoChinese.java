package university.demo;

import java.util.Arrays;

public class DoChinese {

    /*
     * ����������ʶ��ʲôʱ��ð������ֽ�ת��Ϊһ��������?
     * Ӣ���ڼ��������һ���ֽڴ洢��ʶ��Ϊ���������Ӣ����ĸ������
     * �ڼ���������ĵĴ洢�������ֽڣ�
     * 		��һ���ֽڿ϶��Ǹ�����
     * 		�ڶ����ֽڳ������Ǹ���������������������ûӰ�졣
     */

        public static void main(String[] args) {
             //String s = "abcde";
            // �����[97, 98, 99, 100, 101]

            String s = "�Ұ����й�";
            // [-50, -46, -80, -82, -60, -29, -42, -48, -71, -6]
            //eclipseĬ�ϵı����ʽ��GBK����IDEAĬ�ϵı����ʽ��UTF-8�����Ѹ���ΪGBK��

            byte[] bys = s.getBytes();

            //toString(byte[] a)����ָ���������ݵ��ַ�����ʾ��ʽ��
            // �ַ�����ʾ��ʽ�������Ԫ���б���ɣ����ڷ����ţ�"[]"���������(���г����������Ԫ��)
            System.out.println(Arrays.toString(bys));
            System.out.println("ͨ��ʹ��ƽ̨��Ĭ���ַ�������ָ���� byte ���飺");
            //����õ�����String���췽��������ָ���ַ������룬�������Ĭ��new String(bye,"UTF-8");
            System.out.println(new String(bys));
        }
    }

