package university.io;

import java.io.*;

/*
 *��Ч���ٵ��ֽڻ�����BufferInputStream��BufferOutputStream
 *ר���ṩ�˴����������ֽ��࣬���췽������ָ���������Ĵ�С����һ��Ĭ�ϴ�С�㹻
 * ��FileInputStream��FileOutputStream���з�װ��ͨ��������ʵ��
 */
public class CopyMusic_IOBufferFastCopyMusic2 {
        public static void main(String[] args) throws IOException {
            //��ʱ�ķ�������System���У�startΪ��������ʱ��ϵͳ����ʱ�䣬endΪ��������ʱ��ϵͳ����ʱ��
            long start = System.currentTimeMillis();
            for (int j=462;j<=581;j++) {

                method("D:\\CloudMusic\\��ѧ��\\"+j+".mp3","E:\\"+j+".mp3");
            }

            long end = System.currentTimeMillis();
            System.out.println("����ʱ��" + (end - start) + "����");
        }

        // ��Ч�ֽ���һ�ζ�дһ���ֽ����飺
        //�����׳��쳣
        public static void method(String srcString, String destString) throws IOException {
        //���ļ��û��������з�װ
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcString));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destString));

            //Ҳ����ʹ�õ����ֽ�
            byte[] bys = new byte[2048];
            int len = 0;
            while ((len = bis.read(bys)) != -1) {
                bos.write(bys, 0, len);
            }
        //�ͷ���Դ���ͷŵ�Ϊ�������Ķ���
            bos.close();
            bis.close();
        }
}
