package main.java.com.zhimzhou.designPatterns.CallbackPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/25 20:18
 */
public class TeacherCallback implements ICallback {
    private IStudent student;

    public TeacherCallback(IStudent student) {
        this.student = student;
    }

    public void askQuestion(String s) {
        this.student.resolveQuestion(s, this);
    }

    @Override
    public void answer(String s) {
        System.out.println("answer。。。。。" + s);
    }
}
