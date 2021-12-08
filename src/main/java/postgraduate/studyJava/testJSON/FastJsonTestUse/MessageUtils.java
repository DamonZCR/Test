package postgraduate.studyJava.testJSON.FastJsonTestUse;

import com.alibaba.fastjson.JSON;

public class MessageUtils {
    // 封装注册消息:RegisterMesType
    public String RegisMess(int userId, String userPwd, String userName, int userStatus, String sex){
        String user = JSON.toJSONString(new RegisterMes(new User(userId, userPwd, userName, userStatus, sex)));
        String res = JSON.toJSONString(new Message("RegisterMes", user));
        return res;
    }

    // 封装登录消息
    public String LogInMess(int userId, String userPwd, String userName){
        String logM = JSON.toJSONString(new LoginMes(1, "1", "Damon"));
        String res = JSON.toJSONString(new Message("LoginMes", logM));
        return res;
    }

    // 封装信息消息
    public String SmsMess(String cont, int userId){
        String sms = JSON.toJSONString(new SmsMes(cont, userId, "188","",0,""));
        String res = JSON.toJSONString(new Message("SmsMes", sms));
        return res;
    }
}
