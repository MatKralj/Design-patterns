package designpatternsabstractfactory.concreteClasses.boss;

import designpatternsabstractfactory.interfaces.ESWeapon;

public class ESUFOBossGun implements ESWeapon{

    @Override
    public String toString() {
        return "40 damage";
    }

}
