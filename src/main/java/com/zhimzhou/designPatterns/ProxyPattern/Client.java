package main.java.com.zhimzhou.designPatterns.ProxyPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/21 22:10
 */
public class Client {
    public static void main(String[] args) {
        Subject proxySubject = new ProxySubject("main/java/com/zhimzhou");
        proxySubject.doSomeThing();
    }
}
