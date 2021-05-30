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
            // ��װͨ���ڵ���
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    s.getInputStream()));

            // Ϊ�˷�ֹ���Ƴ�ͻ
            //��ȡϵͳ�ĵ�ǰʱ��Ϊ�ļ�����
            String newName = System.currentTimeMillis() + ".java";
            BufferedWriter bw = new BufferedWriter(new FileWriter(newName));

            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }

            //���ͻ��˷���
            BufferedWriter bwServer = new BufferedWriter(
                    new OutputStreamWriter(s.getOutputStream()));
            bwServer.write("�ļ��ϴ��ɹ�");
            bwServer.newLine();
            bwServer.flush();

            //�ͷ���Դ
            bw.close();
            s.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
