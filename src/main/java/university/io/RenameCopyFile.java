package university.io;


import java.io.*;

/*
 *从指定路径复制并重命名文件到指定路径
 * 具有：判断选择指定文件的功能、改文件名称、复制目录文件
 *
 */
public class RenameCopyFile {
    public static void main(String[] args) throws IOException {
        //封装目标目录
        File way = new File("D:\\IDEA\\Test\\src\\usefile");
        //封装目的目录
        File pur = new File("D:\\IDEA");
        File[] allfill = way.listFiles(new FilenameFilter() {//文件接口类
            @Override

            public boolean accept(File dir, String name) {//用于筛选指定文件名的文件
                /*参数：dir - 被找到的文件所在的目录。
                         name - 文件的名称。
                  返回：当且仅当该名称应该包含在文件列表中时返回 true；否则返回 false。*/
                return new File(dir,name).isFile() && name.endsWith(".java");
            }
        });

        for (File exm:allfill) {
            //System.out.println(exm);
            //获取文件数组中文件的名称
            String name = exm.getName();
            // File(File parent,String child)根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例
            File newfile = new File(pur,name);//具有文件路径的属性
            copyfile(exm,newfile);
            //更改指定的名称，也可以单独使用Foreach进行文件改名
          String newname = name.replace(".java",".txt");
            File newfn = new File(pur,newname);//创建好路径名
            newfile.renameTo(newfn);

        }
    }

    private static void copyfile(File exm, File newfile) throws IOException {
        //缓冲字节流实现文件复制
        BufferedInputStream bf  = new BufferedInputStream(new FileInputStream(exm));
        BufferedOutputStream nbf = new BufferedOutputStream(new FileOutputStream(newfile));
            byte[] bys = new byte[1024];
        int len = 0;
        while ((len = bf.read(bys)) != -1){
            //System.out.println(len);
            nbf.write(bys,0,len);
        }
        //释放资源
        bf.close();
        nbf.close();

    }
}
