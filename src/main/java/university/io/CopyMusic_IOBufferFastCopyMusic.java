package university.io;

import java.io.*;

/*
 *高效快速的字节缓冲流BufferInputStream、BufferOutputStream
 *专门提供了带缓冲区的字节类，构造方法可以指定缓冲区的大小，但一般默认大小足够
 * 将FileInputStream、FileOutputStream进行封装，通过缓冲流实现
 */
public class CopyMusic_IOBufferFastCopyMusic {
        public static void main(String[] args) throws IOException {
            //计时的方法。在System类中，start为方法启动时的系统运行时间，end为方法结束时的系统运行时间
            long start = System.currentTimeMillis();
            for (int j=731;j<= 860;j++) {

                method("D:\\CloudMusic\\说岳后传\\"+j+".mp3","E:\\"+j+".mp3");
            }

            long end = System.currentTimeMillis();
            System.out.println("共耗时：" + (end - start) + "毫秒");
        }

        // 高效字节流一次读写一个字节数组：
        //方法抛出异常
        public static void method(String srcString, String destString) throws IOException {
        //将文件用缓冲流进行封装
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcString));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destString));

            //也可以使用单个字节
            byte[] bys = new byte[1024];
            int len = 0;
            while ((len = bis.read(bys)) != -1) {
                bos.write(bys, 0, len);
            }
        //释放资源，释放的为缓冲流的对象
            bos.close();
            bis.close();
        }
}
