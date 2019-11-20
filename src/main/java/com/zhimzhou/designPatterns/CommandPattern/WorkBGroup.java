package main.java.com.zhimzhou.designPatterns.CommandPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/22 22:57
 */
public class WorkBGroup extends Group {
    @Override
    protected void addOneCommand() {
        System.out.println("B 添加一个东西......");
    }

    @Override
    protected void modifyOneCommand() {
        System.out.println("B 修改一个东西......");
    }

    @Override
    protected void deleteOneCommand() {
        System.out.println("B 删除一个东西......");
    }
}
