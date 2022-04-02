package postgraduate.studyJava.faceObject.danJiCheng;

public class OnePerson implements OnStudy,Animal{
    public static void main(String[] args) {
        OnePerson person = new OnePerson();
        System.out.println(OnStudy.live);//11
        System.out.println(Animal.live);//1
    }
}
