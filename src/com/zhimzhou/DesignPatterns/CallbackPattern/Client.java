package com.zhimzhou.DesignPatterns.CallbackPattern;

/**
 * @author zhimzhou
 * @since 2019/1/25 20:22
 */
public class Client {
    public static void main(String[] args) {
        IStudent student = new Student();
        TeacherCallback teacherCallback = new TeacherCallback(student);
        teacherCallback.askQuestion("你是谁?");
    }
}
