package main.java.com.zhimzhou.designPatterns.CommandPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/22 22:56
 */
public class WorkAGroup extends Group {

    @Override
    protected void addOneCommand() {
        System.out.println("A 添加一个东西......");
    }

    @Override
    protected void modifyOneCommand() {
        System.out.println("A 修改一个东西......");
    }

    @Override
    protected void deleteOneCommand() {
        System.out.println("A 删除一个东西......");
    }

}
