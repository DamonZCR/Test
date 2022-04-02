package postgraduate.studyJava.faceObject.danJiCheng;

/**
 * 它代表动物这个接口，live代表活着的状态；
 */
public interface Animal {
    public static final int live = 1;
    public default void living(){}
    public default void eat(){}
}
