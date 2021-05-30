package university.demo;

public class Triangle {
    double a,b,c;
    double area;
    double s ;
    public Triangle(){
        a = 0.0;
        b = 0.0;
        c = 0.0;
    }
    public Triangle(double a,double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public void area(){
        s=(a+b+c)/2;
        System.out.println("Ãæ»ýÎª£º"+(Math.sqrt(s*(s-a)*(s-b)*(s-c))));
    }
    public static void main(String[] args) {
        Triangle t1 = new Triangle(3, 5, 4);
        t1.area();
        Triangle t2 = new Triangle();
        t2.area();
    }
}
