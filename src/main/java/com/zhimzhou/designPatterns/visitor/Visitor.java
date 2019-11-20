package main.java.com.zhimzhou.designPatterns.visitor;

public interface Visitor {
    void visit(Student student);

    void visit(Teacher teacher);
}
