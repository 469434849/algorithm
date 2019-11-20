package main.java.com.zhimzhou.designPatterns.lspPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/17 22:44
 */
public class Client {
    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        soldier.setGun(new HandGun());
        soldier.killEnemy();
        soldier.setGun(new HandGun());
        soldier.killEnemy();
        Snipper snipper = new Snipper();
        snipper.killEnemy(new AUG());
    }
}
