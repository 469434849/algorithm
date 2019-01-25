package com.zhimzhou.DesignPatterns.ResponsibilityChainPattern;

/**
 * @author zhimzhou
 * @since 2019/1/23 22:45
 */
public class SonHandle extends IRequestHandle {

    public SonHandle() {
        super(IRequestHandle.SON_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women){
        System.out.println("---------母亲向儿子请示-----------");
        System.out.println(women.getMessage());
        System.out.println("儿子同意了.");
    }
}
