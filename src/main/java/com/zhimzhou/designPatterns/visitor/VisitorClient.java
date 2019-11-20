package main.java.com.zhimzhou.designPatterns.visitor;

public class VisitorClient {
    public static void main(String[] args) {
        Element element = new Student("zhimzhou", 90, 3);

        Visitor visitor = new GradeSelection();
        element.accept(visitor);
    }
}
