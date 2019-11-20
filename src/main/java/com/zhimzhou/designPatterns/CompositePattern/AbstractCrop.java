package main.java.com.zhimzhou.designPatterns.CompositePattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/26 22:54
 */
public abstract class AbstractCrop {
    private String name;
    private String position;
    private int salary;

    public AbstractCrop(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getInfo(){
        return "姓名:" + this.name + "\t" + "职位:" + this.position + "\t" + "薪水:" + this.salary;
    }
}
