package com.zhimzhou.DesignPatterns.ResponsibilityChainPattern;

/**
 * @author zhimzhou
 * @since 2019/1/23 22:45
 */
public class FatherHandle extends IRequestHandle {

    public FatherHandle() {
        super(IRequestHandle.FATHER_LEVEL_REQUEST);
    }

    @Override
    protected void response(IWomen women){
        System.out.println("---------女儿向父亲请示-----------");
        System.out.println(women.getMessage());
        System.out.println("父亲同意了.");
    }
}
