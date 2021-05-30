package university.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
/**
 *使用集合、随机数，随机获取输出文本文件中的某一个数据
 * 集合
 */
public class GetTextPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader bc = new BufferedReader(new FileReader("D:\\IDEA\\Test\\src\\usefile\\Copy.txt"));
                //使用集合存储字符串
                ArrayList<String> array = new ArrayList<String>();
                String st = null;
                //读取整行
        while((st = bc.readLine()) != null){
            //添加进集合
            array.add(st);
        }
        //释放资源
        bc.close();
        //随机产生一个数，选择第几行被输出
        Random r = new Random();
        int index = r.nextInt(array.size());//在集合的最大范围内产生一个随机数
        String data = array.get(index);//获取集合的第index数据
        System.out.println("随机获取的文件中数据为：\n"+data);
    }
}
