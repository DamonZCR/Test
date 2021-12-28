package postgraduate.studyJava.testCollection.ConcurHM;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class GouZaoFunc1 {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> chm = new ConcurrentHashMap<>();
        chm.put("one", 1);
        System.out.println(chm.get("one"));
        AtomicInteger ac = new AtomicInteger();
    }
}
