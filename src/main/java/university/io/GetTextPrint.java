package university.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
/**
 *ʹ�ü��ϡ�������������ȡ����ı��ļ��е�ĳһ������
 * ����
 */
public class GetTextPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader bc = new BufferedReader(new FileReader("D:\\IDEA\\Test\\src\\usefile\\Copy.txt"));
                //ʹ�ü��ϴ洢�ַ���
                ArrayList<String> array = new ArrayList<String>();
                String st = null;
                //��ȡ����
        while((st = bc.readLine()) != null){
            //��ӽ�����
            array.add(st);
        }
        //�ͷ���Դ
        bc.close();
        //�������һ������ѡ��ڼ��б����
        Random r = new Random();
        int index = r.nextInt(array.size());//�ڼ��ϵ����Χ�ڲ���һ�������
        String data = array.get(index);//��ȡ���ϵĵ�index����
        System.out.println("�����ȡ���ļ�������Ϊ��\n"+data);
    }
}
