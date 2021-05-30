package university.demo;
  /*
  *问题：如何跳出foreach
  * 测试
  *
  *     方法1：使用break。成功退出循环，执行下面代码；
  *     方法2：使用continue。跳过本次循环，仍将继续执行循环
  *     方法3：使用return。成功退出循环，不执行下面代码，代码执行到此处终止；
  *
  * 替换
  *
  *     使用while也可以达到结果
  */
public class ForeachTest {
    public static void main(String[] args){
        //实例化将输出的数组
        int b[] = new int[]{78,34,34,45,54,34,23,879,98};

        System.out.println("1、输出数组中数字，但不输出879：");
        //使用foreach遍历时，a为赋值被输出元素，b为被遍历的数组名
        for (int a : b ) {
            if(a == 879){
                break;
            }
                System.out.print( a +" ");
        }

        System.out.println("\n"+"2、输出数组中数字，但不输出879：");
        for (int a : b ) {
            if(a == 879){
                continue;
            }
            System.out.print( a +" ");
        }

        System.out.println("\n3、输出数组中数字，但不输出879：");
        for (int a : b ) {
            if(a == 879){
                //return;
            }
            System.out.print( a +" ");
        }

        System.out.println("\n不会输出此条语句，因为return将此结束！");

        //测试使用while达到上面的结果，实现了与foreach一样的效果
        int a=0;
        //当满足while条件才执行代码
        while(a != b.length){
            if(b[a] == 879){
                break;
            }
            System.out.print(b[a]+" ");
            a++;

        };
    }
}
