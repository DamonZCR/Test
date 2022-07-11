package postgraduate.studyJava.faceObject;

public interface MyComparable {
    default int compareTo(Object obj){
        System.out.println("接口中的方法有方法体！");
        return 0;
    }
}
