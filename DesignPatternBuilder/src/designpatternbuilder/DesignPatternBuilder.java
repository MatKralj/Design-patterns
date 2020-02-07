package designpatternbuilder;

import designpatternbuilder.concreteClasses.OldRobotBuilder;
import designpatternbuilder.concreteClasses.Robot;
import designpatternbuilder.concreteClasses.RobotEngineer;
import designpatternbuilder.interfaces.RobotBuilder;

public class DesignPatternBuilder {

    public static void main(String[] args) {
        
        RobotBuilder oldStyleRobot = new OldRobotBuilder();
        
        RobotEngineer director = new RobotEngineer(oldStyleRobot);
        
        director.makeRobot();
        
        Robot firstRobot = director.getRobot();

        System.out.println("Robot Built");
        
        System.out.println("Robot Head Type: "+firstRobot.getRobotHead());
        System.out.println("Robot Torso Type: "+firstRobot.getRobotTorso());
        System.out.println("Robot Arms Type: "+firstRobot.getRobotArms());
        System.out.println("Robot Legs Type: "+firstRobot.getRobotLegs());
    } 
}
