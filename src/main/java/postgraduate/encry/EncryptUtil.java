package postgraduate.encry;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncryptUtil {
    private static final Logger logger = LoggerFactory.getLogger(EncryptUtil.class);

    public static String encodeBase64(byte[] bytes){
        String encoded = Base64.getEncoder().encodeToString(bytes);
        return encoded;
    }

    public static byte[]  decodeBase64(String str){
        byte[] bytes = null;
        bytes = Base64.getDecoder().decode(str);
        return bytes;
    }
    //将UTF8格式的字符串以Base64进行 编码
    public static String encodeUTF8StringBase64(String str){
        String encoded = null;
        try {
            encoded = Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            logger.warn("不支持的编码格式",e);
        }
        return encoded;

    }
    //将Base64格式的字符串进行 解码
    public static String  decodeUTF8StringBase64(String str){
        String decoded = null;
        byte[] bytes = Base64.getDecoder().decode(str);
        try {
            decoded = new String(bytes,"utf-8");
        }catch(UnsupportedEncodingException e){
            logger.warn("不支持的编码格式",e);
        }
        return decoded;
    }

    public static String encodeURL(String url) {
    	String encoded = null;
		try {
			encoded =  URLEncoder.encode(url, "utf-8");
		} catch (UnsupportedEncodingException e) {
			logger.warn("URLEncode失败", e);
		}
		return encoded;
	}


	public static String decodeURL(String url) {
    	String decoded = null;
		try {
			decoded = URLDecoder.decode(url, "utf-8");
		} catch (UnsupportedEncodingException e) {
			logger.warn("URLDecode失败", e);
		}
		return decoded;
	}

    public static void main(String [] args){
        String str = "abcd{'a':'b'}";
        String encoded = EncryptUtil.encodeUTF8StringBase64(str);
        String decoded = EncryptUtil.decodeUTF8StringBase64(encoded);
        System.out.println(str);
        System.out.println(encoded);
        System.out.println(decoded);

        String url = "== wo";
        String urlEncoded = EncryptUtil.encodeURL(url);
        String urlDecoded = EncryptUtil.decodeURL(urlEncoded);
        
        System.out.println(url);
        System.out.println(urlEncoded);
        System.out.println(urlDecoded);

        //测试解码一个 JWT 的负载部分；测试发现可以成功的将一个JWT的负载部分解析出JSON格式；
        String s = "eyJhdWQiOlsicmVzMSJdLCJ1c2VyX25hbWUiOiJ7XCJmdWxsbmFtZVwiOlwi5byg5LiJXCIsXCJpZFwiOlwiMVwiLFwicGFzc3dvcmRcIjpcIiQyYSQxMCRTdFUxTGxnY285TG5MWjBodENTWHAuYzFGWlZlTXdHay9Dc3JncFlES0VBYzE5UkZoa2luU1wiLFwidXNlcm5hbWVcIjpcInpoYW5nc2FuXCJ9Iiwic2NvcGUiOlsiUk9MRV9BRE1JTiIsIlJPTEVfVVNFUiIsIlJPTEVfQVBJIl0sImV4cCI6MTY1ODc0MDU5NSwiYXV0aG9yaXRpZXMiOlsicDEiLCJwMyJdLCJqdGkiOiJiYWQyYmU0YS1mNzhhLTRjMTktYjc3My05ZjkwZTZlNDVlN2QiLCJjbGllbnRfaWQiOiJjMSJ9";
        System.out.println(EncryptUtil.decodeUTF8StringBase64(s));
    }


}
