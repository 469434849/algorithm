package main.java.com.zhimzhou.designPatterns.ResponsibilityChainPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/23 22:37
 */
public abstract class IRequestHandle {
    public static final int FATHER_LEVEL_REQUEST = 1;
    public static final int HUSBAND_LEVEL_REQUEST = 2;
    public static final int SON_LEVEL_REQUEST = 3;

    private int level;
    private IRequestHandle nextHandle;

    public IRequestHandle(int level) {
        this.level = level;
    }

    public final void handleMessage(IWomen women) {
        if (women.getType() == this.level) {
            this.response(women);
        } else {
            if (this.nextHandle != null) {
                this.nextHandle.handleMessage(women);
            } else {
                System.out.println("这个请求没有人处理......");
            }
        }
    }

    public void setNextHandle(IRequestHandle handle) {
        this.nextHandle = handle;
    }

    protected abstract void response(IWomen women);
}
