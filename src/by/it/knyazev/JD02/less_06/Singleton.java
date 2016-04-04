package by.it.knyazev.JD02.less_06;

/**
 * Created by Mac on 21.03.16.
 */
public class Singleton {

    public static Singleton instance = new Singleton();

    private  Singleton(){}

    public static Singleton getInstance(){
        System.out.println("sad");
        return instance;
    }

}
