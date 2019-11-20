package main.java.com.zhimzhou.designPatterns.ResponsibilityChainPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/23 22:42
 */
public class Women implements IWomen {
    private int type;
    private String message;

    public Women(int type) {
        this.type = type;
        switch (this.type) {
            case 1:
                this.message = "女儿向父亲发出请求";
                break;
            case 2:
                this.message = "妻子向丈夫发出请求";
                break;
            case 3:
                this.message = "母亲向儿子发出请求";
                break;
            default:
                this.message = "不知道发给谁的请求";
                break;
        }
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
