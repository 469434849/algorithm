package main.java.com.zhimzhou.designPatterns.lspPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/17 22:45
 */
public class Soldier {
    private AbstractGun gun;


    public AbstractGun getGun() {
        return gun;
    }

    public void setGun(AbstractGun gun) {
        this.gun = gun;
    }

    public void killEnemy() {
        System.out.println("开始杀敌...");
        gun.shoot();
    }
}
