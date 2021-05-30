## ǳ̸Java�е�final�ؼ���
  ̸��final�ؼ��֣���غܶ��˶���İ������ʹ�������ڲ����ʱ����ܻᾭ���õ�final�ؼ��֡�
���⣬Java�е�String�����һ��final�࣬��ô�������Ǿ����˽�final����ؼ��ֵ��÷���

### **һ��final�ؼ��ֵĻ����÷�**

��Java�У�final�ؼ��ֿ������������ࡢ�����ͱ�����������Ա�����;ֲ���������
����ʹ��������������˽�һ��final�ؼ��ֵĻ����÷���

#### **1��������**

�� ����final����һ����ʱ����������಻�ܱ��̳С�Ҳ����˵�����һ��������Զ�����������̳У��Ϳ�����final�������Ρ�

final���еĳ�Ա�������Ը�����Ҫ��Ϊfinal������Ҫע��final���е����г�Ա�������ᱻ��ʽ��ָ��Ϊfinal������
```java
final class People{
    public People(){
    }
}
class Man extends People{//�˴�����

}
```
��ʹ��final�������ʱ��Ҫע�����ѡ�񣬳��������������Ժ󲻻������̳л��߳��ڰ�ȫ�Ŀ��ǣ�������Ҫ�������Ϊfinal�ࡣ

#### **2�����η���**
������λ�ժ�ԡ�Java���˼�롷���İ��143ҳ��

����ʹ��final������ԭ������������һ��ԭ���ǰѷ����������Է��κμ̳����޸����ĺ��壻�ڶ���ԭ����Ч�ʡ������ڵ�Javaʵ�ְ汾�У��Ὣfinal����תΪ��Ƕ���á�����������������Ӵ󣬿��ܿ�������Ƕ���ô������κ������������������Java�汾�У�����Ҫʹ��final����������Щ�Ż��ˡ���
��ˣ����ֻ��������ȷ��ֹ �÷����������б����ǵ�����²Ž���������Ϊfinal�ġ��������final�����ǲ��ܱ����������ǵģ�Ҳ����˵�����ǲ��ܹ����ں͸���һģһ���ķ����ġ�

final���εķ�����ʾ�˷����Ѿ��ǡ����ġ����յġ����壬�༴�˷������ܱ���д���������ض��final���εķ��������˴���Ҫע���һ���ǣ���Ϊ��д��ǰ����������ԴӸ����м̳д˷�����
���������final���εķ���ͬʱ���ʿ���Ȩ��Ϊprivate�����ᵼ�������в���ֱ�Ӽ̳е��˷�������ˣ���ʱ�����������ж�����ͬ�ķ������Ͳ�������ʱ���ٲ�����д��final��ì�ܣ����������������¶������µķ�������ע�����private��������ʽ�ر�ָ��Ϊfinal��������

```java
public class B extends A {
    public static void main(String[] args) {
    }
    public void getName() {
    }
}
class A {
    /**
     * ��Ϊprivate���Σ������в��ܼ̳е��˷�������ˣ������е�getName���������¶���ġ�
     * �������౾��ķ�������������
     */
    private final void getName() {
    }
    /* ��Ϊpublic���Σ�������Լ̳е��˷�����������д�˸����final�������������
    public final void getName() {
    }
    */
}
```
#### **3�����α���**

      ���α�����final�õ����ĵط���Ҳ�Ǳ��Ľ�����Ҫ�ص���������ݡ�
      final��Ա������ʾ������ֻ�ܱ���ֵһ�Σ���ֵ��ֵ���ٸı䡣

������final����һ��������������ʱ����ʾ�û����������͵�ֵһ���ڳ�ʼ����㲻�ܷ����仯�����final����һ����������ʱ�����ڶ����ʼ��֮��㲻��������ָ�����������ˣ�����������ָ��Ķ���������ǿ��Է����仯�ġ���������һ���£���Ϊ���õ�ֵ��һ����ַ��finalҪ��ֵ������ַ��ֵ�������仯��

����final����һ����Ա���������ԣ�������Ҫ��ʾ��ʼ�������������ֳ�ʼ����ʽ��һ�����ڱ���������ʱ���ʼ�����ڶ��ַ�����������������ʱ�򲻸���ֵ������Ҫ������������ڵ�������еĹ��캯���ж������������ֵ��

�����������Ĳ�����������Ϊfinalʱ��˵���ò�����ֻ���͵ġ�������Զ�ȡʹ�øò����������޷��ı�ò�����ֵ��

�ٸ����ӣ�
```java
class Man{
        private final int i = 0;
        public Man(){
            i = 1;//����
            final Object obj = new Object();
            obj = new Object();//����
        }
}
```
�����һ�δ����У��Ա���i��obj�����¸�ֵ�������ˡ�

###�����������final�ؼ���

���˽���final�ؼ��ֵĻ����÷�֮����һ����������һ��final�ؼ������׻����ĵط���

####**1�����final��������ͨ������ʲô����**

����final��������ĳ�Ա����ʱ����Ա������ע������ĳ�Ա�������ֲ�����ֻ��Ҫ��֤��ʹ��֮ǰ����ʼ����ֵ���ɣ������ڶ���ʱ���߹������н��г�ʼ����ֵ������final����һ������ʼ����ֵ֮�󣬾Ͳ����ٱ���ֵ�ˡ�
��ôfinal��������ͨ���������к������أ������뿴һ�����ӣ�
```java
public class VariableTest {
    public static void main(String[] args) {
        String a = "hello2";
        final String b = "hello";
        String c = "hello";

        String d = b + 2;
        String e = c + 2;
        System.out.println(a == d);//true
        System.out.println(e);//hello2
        System.out.println(a == e);//false
    }
}
```
��������true��false
��ҿ�������һ����������������Ϊʲô��һ���ȽϽ��Ϊtrue�����ڶ����ȽϽ��Ϊfasle�����������final��������ͨ�����������ˣ�
��final�����ǻ������������Լ�String����ʱ������ڱ����ڼ���֪������ȷ��ֵ�����������������������ڳ���ʹ�á�Ҳ����˵���õ���final�����ĵط����൱��ֱ�ӷ��ʵ��������������Ҫ������ʱȷ�������ֺ�C�����еĺ��滻�е�������������һ�δ����У����ڱ���b��final���Σ���˻ᱻ����������������������ʹ�õ�b�ĵط���ֱ�ӽ�����b �滻Ϊ����ֵ�������ڱ���e�ķ���ȴ��Ҫ������ʱͨ�����������С�������е�������Ӧ�������ˣ�����Ҫע�⣬ֻ���ڱ����ڼ���ȷ��֪��final����ֵ������£��������Ż�����������Ż��������������δ���Ͳ�������Ż���
```java
public class VariableTest2 {
    public static void main(String[] args) {
        String a = "hello2";
        final String b = getHello();

        String c = b + 2;
        System.out.println(a == c);//false
    }
    public static String getHello(){
        return  "hello";
    }
}
```
��δ����������Ϊfalse������Ҫע��һ����ǣ���Ҫ��ΪĳЩ������final�Ϳ����ڱ�����֪����ֵ��ͨ������b���Ǿ�֪���ˣ���������ʹ��getHello()����������г�ʼ������Ҫ�������ڲ���֪����ֵ��
####**2����final���ε����ñ���ָ��Ķ������ݿɱ���**
�������ᵽ��final���ε����ñ���һ����ʼ����ֵ֮��Ͳ�����ָ�������Ķ�����ô�����ñ���ָ��Ķ�������ݿɱ��𣿿�����������ӣ�
```java
public class Test { 
    public static void main(String[] args)  { 
        final MyClass myClass = new MyClass(); 
        System.out.println(++myClass.i); 
    } 
} 
class MyClass { 
    public int i = 0; 
}
```
��δ������˳������ͨ����������������������Ϊ1����˵�����ñ�����final����֮����Ȼ������ָ���������󣬵�����ָ��Ķ���������ǿɱ�ġ�
####**3��final����������**
 ��ʵ��Ӧ���У����ǳ��˿�����final���γ�Ա��������Ա�������࣬���������β�������ĳ��������final�����ˣ�������˸ò����ǲ��ɸı�ġ�����ڷ����������޸��˸ò����������������ʾ�㣺The final local variable i cannot be assigned. It must be blank and not using a compound assignment������������ӣ�
```java
public class finalVariable {
    public static void main(String[] args) {
        int i = 0;
        changeValue(i);
        i++;
        System.out.println(i);// 1
    }
    private static void changeValue(final int i) {
        //i++;  final����Ĳ������ɱ��ı䡣
        System.out.println(i);// 0
    }
}
```
������δ���changeValue�����еĲ��� i ��final����֮�󣬾Ͳ����ڷ����и��ı��� i ��ֵ�ˡ�ֵ��ע���һ�㣬����changeValue��main�����еı��� i �����Ͳ���һ����������Ϊjava�������ݲ��õ���ֵ���ݣ����ڻ������͵ı������൱��ֱ�ӽ����������˿��������Լ�ʹû��final���ε�����£��ڷ����ڲ��ı��˱��� i ��ֵҲ����Ӱ�췽����� i ��

�ٿ�������δ��룺
```java
public class finalVariable2 {
    public static void main(String[] args) {
        int i = 0;
        StringBuffer buffer = new StringBuffer("Hello");
        changeValue(buffer);
        System.out.println(buffer);//��� Hello World��
    }
    private static void changeValue(final StringBuffer buffer) {
        //buffer�Ѿ���final���Σ�����������ָ���������󣬵��Ƕ����������ǿ��Ը��ĵġ�ֻ�Ǹ������ݡ�
        //����final����ı����Ѿ��̶��ǳ�����һ�����ƣ�����final����ֻ�ܸ������ݡ�
        //buffer  = new StringBuffer("Hi");�˴�����

        buffer.append(" World!");
    }
}
```
������δ���ͻᷢ��������Ϊ Hello world�� ����Ȼ����final���������䲻������bufferָ���������󣬵�����bufferָ��Ķ���������ǿ��Ըı�ġ����ڼ���һ������������finalȥ��������ֻ�������������Ĵ��룺
```java
public class finalVariable3 {
    public static void main(String[] args) {
        int i = 0;
        StringBuffer buffer = new StringBuffer("Hello");
        changeValue(buffer);
        System.out.println(buffer);//  Hello
    }
    private static void changeValue(StringBuffer buffer) {
        //ע��������������ββ�û���õ�����ʾ��ɫ��
        buffer  = new StringBuffer("Hi");
        buffer.append(" World!");
        System.out.println(buffer);//  Hi World!
    }
}
```
���н����
```
hiworld
hello
```
�����н�����Կ�������finalȥ����ͬʱ��changeValue����bufferָ�����������󣬲�����Ӱ�쵽main�����е�buffer��ԭ������java���õ���ֵ���ݣ��������ñ��������ݵ������õ�ֵ��Ҳ����˵��ʵ�κ��β�ͬʱָ����ͬһ������������β�����ָ����һ�������ʵ�β�û���κ�Ӱ�졣












