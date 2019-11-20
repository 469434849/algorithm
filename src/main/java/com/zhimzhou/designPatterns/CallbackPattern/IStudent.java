package main.java.com.zhimzhou.designPatterns.CallbackPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/25 20:19
 */
public interface IStudent {
    void resolveQuestion(String question,ICallback callback);
}
