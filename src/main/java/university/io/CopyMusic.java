package university.io;


import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 *��ָ��·�����Ʋ��������ļ���ָ��·��
 * ���У��ж�ѡ��ָ���ļ��Ĺ��ܡ����ļ����ơ�����Ŀ¼�ļ�
 *
 */
public class CopyMusic {
    public static void main(String[] args) throws IOException {
        //��װĿ��Ŀ¼
        File way = new File("F:\\");
        //��װĿ��Ŀ¼
        File pur = new File("E:\\");
        File[] allfill = way.listFiles(new FilenameFilter() {//�ļ��ӿ���
            @Override

            public boolean accept(File dir, String name) {//����ɸѡָ���ļ������ļ�
                /*������dir - ���ҵ����ļ����ڵ�Ŀ¼��
                         name - �ļ������ơ�
                  ���أ����ҽ���������Ӧ�ð������ļ��б���ʱ���� true�����򷵻� false��*/
                return new File(dir,name).isFile() && name.endsWith(".mp3");
            }
        });
        List fileList = Arrays.asList(allfill);
        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if (o1.isDirectory() && o2.isFile())
                    return -1;
                if (o1.isFile() && o2.isDirectory())
                    return 1;
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (File exm:allfill) {
            //System.out.println(exm);
            //��ȡ�ļ��������ļ�������
            String name = exm.getName();
            // File(File parent,String child)���� parent ����·������ child ·�����ַ�������һ���� File ʵ��
            File newfile = new File(pur,name);//�����ļ�·��������
            copyfile(exm,newfile);
            //����ָ�������ƣ�Ҳ���Ե���ʹ��Foreach�����ļ�����
          String newname = name.replace(".mp3",".mp3");
            File newfn = new File(pur,newname);//������·����
            newfile.renameTo(newfn);

        }
    }

    private static void copyfile(File exm, File newfile) throws IOException {
        //�����ֽ���ʵ���ļ�����
        BufferedInputStream bf  = new BufferedInputStream(new FileInputStream(exm));
        BufferedOutputStream nbf = new BufferedOutputStream(new FileOutputStream(newfile));
            byte[] bys = new byte[2048];
        int len = 0;
        while ((len = bf.read(bys)) != -1){
            //System.out.println(len);
            nbf.write(bys,0,len);
        }
        //�ͷ���Դ
        bf.close();
        nbf.close();

    }
}
