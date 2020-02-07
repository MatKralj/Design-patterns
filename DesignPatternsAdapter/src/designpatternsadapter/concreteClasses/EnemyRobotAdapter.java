package designpatternsadapter.concreteClasses;

import designpatternsadapter.interfaces.EnemyAttacker;

public class EnemyRobotAdapter implements EnemyAttacker{

    EnemyRobot theRobot;
    public EnemyRobotAdapter(EnemyRobot robot){
        this.theRobot = robot;
    }
    @Override
    public void fireWeapon() {
        theRobot.smashWithHands();
    }

    @Override
    public void driveForward() {
        theRobot.walkForward();
    }

    @Override
    public void assignDriver(String driverName) {
        theRobot.reactToHuman(driverName);
    }
    
}
