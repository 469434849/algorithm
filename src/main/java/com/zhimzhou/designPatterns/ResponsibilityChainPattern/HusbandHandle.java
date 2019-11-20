package main.java.com.zhimzhou.designPatterns.ResponsibilityChainPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/23 22:45
 */
public class HusbandHandle extends IRequestHandle {

    public HusbandHandle() {
        super(HUSBAND_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women){
        System.out.println("---------妻子向丈夫请示-----------");
        System.out.println(women.getMessage());
        System.out.println("丈夫同意了.");
    }
}
