package main.java.com.zhimzhou.designPatterns.ResponsibilityChainPattern;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/23 22:55
 */
public class Client {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<IWomen> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList.add(new Women((random.nextInt(5))));
        }
        IRequestHandle fatherHandle = new FatherHandle();
        IRequestHandle husbandHandle = new HusbandHandle();
        IRequestHandle sonHandle = new SonHandle();
        fatherHandle.setNextHandle(husbandHandle);
        husbandHandle.setNextHandle(sonHandle);
        arrayList.forEach(fatherHandle::handleMessage);
    }
}
