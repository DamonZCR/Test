package university.io;


import java.io.*;

/*
 *��ָ��·�����Ʋ��������ļ���ָ��·��
 * ���У��ж�ѡ��ָ���ļ��Ĺ��ܡ����ļ����ơ�����Ŀ¼�ļ�
 *
 */
public class RenameCopyFile {
    public static void main(String[] args) throws IOException {
        //��װĿ��Ŀ¼
        File way = new File("D:\\IDEA\\Test\\src\\usefile");
        //��װĿ��Ŀ¼
        File pur = new File("D:\\IDEA");
        File[] allfill = way.listFiles(new FilenameFilter() {//�ļ��ӿ���
            @Override

            public boolean accept(File dir, String name) {//����ɸѡָ���ļ������ļ�
                /*������dir - ���ҵ����ļ����ڵ�Ŀ¼��
                         name - �ļ������ơ�
                  ���أ����ҽ���������Ӧ�ð������ļ��б���ʱ���� true�����򷵻� false��*/
                return new File(dir,name).isFile() && name.endsWith(".java");
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
          String newname = name.replace(".java",".txt");
            File newfn = new File(pur,newname);//������·����
            newfile.renameTo(newfn);

        }
    }

    private static void copyfile(File exm, File newfile) throws IOException {
        //�����ֽ���ʵ���ļ�����
        BufferedInputStream bf  = new BufferedInputStream(new FileInputStream(exm));
        BufferedOutputStream nbf = new BufferedOutputStream(new FileOutputStream(newfile));
            byte[] bys = new byte[1024];
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
