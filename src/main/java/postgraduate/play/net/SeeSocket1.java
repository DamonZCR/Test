package postgraduate.play.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

public class SeeSocket1 {
    public static void main(String[] args) throws MalformedURLException {
        BufferedWriter bw = null;
        BufferedReader br = null;
        Socket socket = null;
        String urlstr = "https://www.baidu.com/";
        URL url;
        try {
            url = new URL(urlstr);
            System.out.println(url.getHost());
            socket = new Socket();
            socket.connect(new InetSocketAddress(url.getHost(),80));
            socket.setSoTimeout(10000);
            OutputStream outputStream = socket.getOutputStream();
            bw = new BufferedWriter(new OutputStreamWriter(outputStream));
            bw.write("GET " + urlstr + " HTTP/1.0\r\n");
            bw.write("HOST:" + "118.89.247.210" + "\r\n");
            bw.write("\r\n");
            bw.flush();

//          bw.write("GET " + urlPojo.getUrl() + " HTTP/1.0\r\n");
//          bw.write("HOST:" + host + "\r\n");
//          //在行的结束符\r\n之前没有任何数据，说明  这时候代表协议族 http header输出给服务端完成
//          bw.write("\r\n");
//          bw.flush();
            InputStream inputStream = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
}
