package designpatternsadapter;

import designpatternsadapter.concreteClasses.EnemyRobot;
import designpatternsadapter.concreteClasses.EnemyRobotAdapter;
import designpatternsadapter.concreteClasses.EnemyTank;
import designpatternsadapter.interfaces.EnemyAttacker;

public class DesignPatternsAdapter {

    public static void main(String[] args) {
        
        EnemyTank rx7Tank = new EnemyTank();
        EnemyRobot fredTheRobot = new EnemyRobot();
        EnemyAttacker robotAdapter = new EnemyRobotAdapter(fredTheRobot);
        
        System.out.println("The robot");
        fredTheRobot.reactToHuman("Paul");
        fredTheRobot.walkForward();
        fredTheRobot.smashWithHands();
        
        System.out.println("The enemy tank");
        rx7Tank.assignDriver("Frank");
        rx7Tank.driveForward();
        rx7Tank.fireWeapon();
        
        System.out.println("The robot with adapter");
        robotAdapter.assignDriver("Mark");
        robotAdapter.driveForward();
        robotAdapter.fireWeapon();
    }
    
}
