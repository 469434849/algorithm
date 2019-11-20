package main.java.com.zhimzhou.designPatterns.CallbackPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/25 20:21
 */
public class Student implements IStudent {
    @Override
    public void resolveQuestion(String question,ICallback callback) {
        System.out.println("学生正在解决问题....."+question+"\n得到答案后告诉老师.");
        callback.answer("main/java/com/zhimzhou");
    }
}
