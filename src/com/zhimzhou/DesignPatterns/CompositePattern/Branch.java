package com.zhimzhou.DesignPatterns.CompositePattern;

import java.util.ArrayList;

/**
 * @author zhimzhou
 * @since 2019/1/26 22:59
 */
public class Branch extends AbstractCrop {
    private ArrayList<AbstractCrop> subordinateList = new ArrayList<>();

    public Branch(String name, String position, int salary) {
        super(name, position, salary);
    }

    /**
     * 添加下属
     * @param crop
     */
    public void addSubordinate(AbstractCrop crop){
        this.subordinateList.add(crop);
    }

    /**
     * 获取下属信息
     *
     * @return
     */
    public ArrayList<AbstractCrop> getSubordinate(){
        return this.subordinateList;
    }

}
