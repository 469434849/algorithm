package main.java.com.zhimzhou.designPatterns.PrototypePattern;

import java.util.ArrayList;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/22 21:58
 */
public class User implements Cloneable {
    private String name = "main/java/com/zhimzhou";
    private final ArrayList<String> arrayList = new ArrayList<>();

    public String getName() {
        return this.name;
    }

    @Override
    protected User clone(){
        User user = null;
        try {
            user = (User)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return user;
    }

    public void addOne(String s) {
        this.arrayList.add(s);
    }

    public ArrayList<String> outputArrayList() {
        return this.arrayList;
    }
}
