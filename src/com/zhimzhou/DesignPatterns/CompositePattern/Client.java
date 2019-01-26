package com.zhimzhou.DesignPatterns.CompositePattern;

import java.util.ArrayList;

/**
 * @author zhimzhou
 * @since 2019/1/26 23:02
 */
public class Client {

    public static void main(String[] args) {
        Branch root = compositeCorpTree();
        System.out.println(root.getInfo());
        System.out.println(getTreeInfo(root));
    }

    public static Branch compositeCorpTree(){
        Branch root = new Branch("王大麻子","总经理",10000);
        Branch developDep = new Branch("刘大瘸子","研发部门经理",1000);
        Branch salesDep = new Branch("马二拐子","销售部门经理",1000);
        Branch financeDep = new Branch("赵三驼子","财务部门经理",1000);
        Branch firstDepGroup = new Branch("李四","开发一组组长",1000);
        Branch secondDepGroup = new Branch("李五","开发二组组长",1000);
        Leaf a = new Leaf("a","开发人员",200);
        Leaf b = new Leaf("b","开发人员",200);
        Leaf c = new Leaf("c","开发人员",200);
        Leaf d = new Leaf("d","开发人员",200);
        Leaf e = new Leaf("e","开发人员",200);
        Leaf f = new Leaf("f","开发人员",200);
        Leaf g = new Leaf("g","开发人员",200);
        Leaf h = new Leaf("h","销售人员",200);
        Leaf i = new Leaf("i","销售人员",200);
        Leaf j = new Leaf("j","财务人员",200);
        Leaf k = new Leaf("k","ceo秘书",200);
        root.addSubordinate(developDep);
        root.addSubordinate(salesDep);
        root.addSubordinate(financeDep);
        root.addSubordinate(k);
        developDep.addSubordinate(firstDepGroup);
        developDep.addSubordinate(secondDepGroup);
        firstDepGroup.addSubordinate(a);
        firstDepGroup.addSubordinate(b);
        firstDepGroup.addSubordinate(c);
        firstDepGroup.addSubordinate(d);
        secondDepGroup.addSubordinate(e);
        secondDepGroup.addSubordinate(f);
        secondDepGroup.addSubordinate(g);
        salesDep.addSubordinate(h);
        salesDep.addSubordinate(i);
        financeDep.addSubordinate(j);
        return root;
    }

    public static String getTreeInfo(Branch root){
        ArrayList<AbstractCrop> subordinate = root.getSubordinate();
        StringBuilder info = new StringBuilder();
        for (AbstractCrop c :subordinate) {

            if (c instanceof Leaf) {
                info.append(c.getInfo()).append("\n");
            } else {
                info.append(c.getInfo()).append("\n").append(getTreeInfo((Branch) c));
            }
        }
        return info.toString();
    }


}
