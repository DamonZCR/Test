package postgraduate.studyJava.kuangJia;

import io.jsonwebtoken.*;
import java.util.Date;
import java.util.UUID;

/** JWT的简单使用
 * 1、什么是JWT?
 * JSON Web Token，通过数字签名的方式，以JSON对象为载体，在不同的服务终端之间安全的传输信息。
 * 就是把信息进行安全的封装，然后以JSON为载体进行传送；
 * 2、JWT有什么用?
 *     JWT最常见的场景就是授权认证，一旦用户登录，后续每个请求都将包含JWT，系统在每次处理用户
 *     请求的之前，都要先进行JWT安全校验，通过之后再进行处理。
 * 3、组成
 *    1、Header
 *    2、payload
 *    3、signature
 *
 */
public class TestJWT {
    private long time = 1000 * 60 * 60 * 24;//一天的时间
    private String signature = "password";// 它的作用就是为了hash加盐

    @org.junit.Test
    public void jwt(){
        JwtBuilder jwtBuilder = Jwts.builder();//构建出JWT对象的；
        // 创建Header、Payload和Signature组成的jwtToken

        String jwtToken =
                // Header
                //token类型
                jwtBuilder.setHeaderParam("typ","JWT")
                        // 算法类型
                        .setHeaderParam("alg","HS256")
                        // payload 载荷，就是可以添加的任意附加信息
                        // 此处可以添加个人信息
                        .claim("username", "tom")
                        .claim("role","admin")
                        // 设置一个主题，可选，这里就是为了举例；
                        .setSubject("admin-test")
                        // 设置过期时间，就是这个token能够使用的期限，有用；
                        // 可以使用获取系统当前时间，然后加上想要持续的时间；
                        .setExpiration(new Date(System.currentTimeMillis() + time))
                        // 设置这个JWT的id，这里使用系统生成
                        .setId(UUID.randomUUID().toString())
                        // Signature,只需要设置签名算法和签名密钥
                        // 这里使用签名算法要和Header中指定算法要匹配；
                        .signWith(SignatureAlgorithm.HS256, signature)
                        // 将这三部分拼接起来；成为JWTtoken字符串；
                        .compact();
        // 客户端和服务器就可以使用这个token进行交互
        System.out.println(jwtToken);
    }

    // 服务器怎么验证或者说解密这个token呢？
    @org.junit.Test
    public void parse(){
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9" +
                ".eyJ1c2VybmFtZSI6InRvbSIsInJvbGUiOiJhZG1pbiIsInN1YiI6ImFkbWluLXRlc3QiLCJleHAiOjE2NTA2MTQxMDQsImp0aSI6ImE4ZjBjMzNiLWE5ZjQtNDE3MC04OTg0LWRjNDk5N2RmZjdlMSJ9" +
                ".3EveMMT7i7t2p8Y8KRPin6Uk9yf7rZq5J6CM3unXCGo";
        // 获得JWT的解密校验对象
        JwtParser jwtParser = Jwts.parser();
        // 使用解密密钥key进行解密,其实解密就是hash校验，要用到key就行去盐比对；
        // 使用signature进行解析token，然后就是返回多个claim，类似于集合的对象
        Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();// 就会返回封装在token中的有用数据；
        // 获取数据
        System.out.println(claims.get("username"));
        System.out.println(claims.get("role"));
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getExpiration());
    }

}
