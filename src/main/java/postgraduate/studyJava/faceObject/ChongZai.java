package postgraduate.studyJava.faceObject;

/**
 * 理解重载：
 * 是在一个类里面，方法名字相同，而参数不同。返回类型可以相同也可以不同。
 * 每个重载的方法（或者构造函数）都必须有一个独一无二的参数类型列表。
 *最常用的地方就是构造器的重载。
 *
 * 重载规则：
 * 1，被重载的方法必须改变参数列表（参数个数或者类型不一样）。
 * 2，被重载的方法可以改变返回类型。
 * 3，被重载的方法可以改变访问修饰符。
 */
public class ChongZai {
    public int test(){
        System.out.println("test1");
        return 1;
    }
    public void test(int a){
        System.out.println("test2");
    }
    //以下两个参数类型顺序不同
    public String test(int a,String s){
        System.out.println("test3");
        return "returntest3";
    }
    public String test(String s,int a){
        System.out.println("test4");
        return "returntest4";
    }
    public static void main(String[] args){
        ChongZai o = new ChongZai();
        System.out.println(o.test());
        o.test(1);
        System.out.println(o.test(1,"test3"));
        System.out.println(o.test("test4",1));
    }
}
