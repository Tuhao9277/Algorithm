/**
 * @Classname singleton1
 * @Description TODO
 * @Date 2019-03-19 16:16
 * @Created by guo
 */
public class singleton1 {
    private static singleton1 ourInstance = new singleton1();

    public static singleton1 getInstance() {
        return ourInstance;
    }

    private singleton1() {
    }
}
