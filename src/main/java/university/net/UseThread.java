package university.net;

import java.io.*;
import java.net.Socket;

public class UseThread implements Runnable {

    private Socket s;
    public UseThread(Socket s) {
        this.s = s;
    }


    @Override
    public void run() {
        try {
            // 封装通道内的流
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    s.getInputStream()));

            // 为了防止名称冲突
            //获取系统的当前时间为文件命名
            String newName = System.currentTimeMillis() + ".java";
            BufferedWriter bw = new BufferedWriter(new FileWriter(newName));

            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }

            //给客户端反馈
            BufferedWriter bwServer = new BufferedWriter(
                    new OutputStreamWriter(s.getOutputStream()));
            bwServer.write("文件上传成功");
            bwServer.newLine();
            bwServer.flush();

            //释放资源
            bw.close();
            s.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
