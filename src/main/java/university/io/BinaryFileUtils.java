package university.io;

import java.io.*;

/**
 * ByteArrayOutputStream的输出目标是一个byte数组，这个数组的长度是根据数据内容动态扩展的。
 * 有两个构造方法：
 * public ByteArrayOutputStream()
 * public ByteArrayOutputStream(int size)
 * 第二个构造方法中的size指定的就是初始的数组大小，如果没有指定，则长度为32。在调用write方法
 * 的过程中，如果数组大小不够，会进行扩展，扩展策略同样是指数扩展，每次至少增加一倍。
 */
public class BinaryFileUtils {
    public static void copy(InputStream input, OutputStream output)
            throws IOException {
        byte[] buf = new byte[4096];
        int bytesRead = 0;
        while ((bytesRead = input.read(buf)) != -1) {
            output.write(buf, 0, bytesRead);
        }
    }

    public static byte[] readFileToByteArray(String fileName)
            throws IOException {
        InputStream input = new FileInputStream(fileName);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            copy(input, output);
            return output.toByteArray();
        } finally {
            input.close();
        }
    }

    public static void writeByteArrayToFile(String fileName, byte[] data)
            throws IOException {
        OutputStream output = new FileOutputStream(fileName);
        try {
            output.write(data);
        } finally {
            output.close();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
