package main.java.com.zhimzhou.designPatterns.PrototypePattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/22 22:04
 */
public class Client {
    public static void main(String[] args){
        User u = new User();
        u.addOne("张三");
        System.out.println(u.outputArrayList());
        User clone = u.clone();
        clone.addOne("里斯");
        System.out.println(clone.outputArrayList());
    }
}
