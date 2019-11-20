package main.java.com.zhimzhou.designPatterns.visitor;

public interface Element {
    void accept(Visitor visitor);
}
