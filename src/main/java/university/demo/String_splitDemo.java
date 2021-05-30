package university.demo;
//字符串分割方法split（）；
/*Java中，按某个字符分割字符串使用的是String对象的split()方法，返回的是分割之后的String数组，
        值得注意的是分割符。当分割符是 . 或者是 | 时，必须使用 \\ 进行转义。*/
public class String_splitDemo {
    public static void main(String[] args) {
        String s = "al_f|f.ggl|oil_.k|";//最后一个分割出空，并没有记录
        String[] splituse = s.split("\\|");
        for (String string:splituse){
            System.out.println(string);
        }
    }
}