package designpatternbuilder.interfaces;

import designpatternbuilder.concreteClasses.Robot;

public interface RobotBuilder {
    
    //public RobotBuilder buildRobotHead(String head);
    //public RobotBuilder buildRobotTorso(String torso);
    //public RobotBuilder buildRobotArms(String arms);
    //public RobotBuilder buildRobotLegs(String legs);
    //public Robot build();
    
    //Stvaranje: RobotBuilder rb = new RobotBuidler();
    //  Robot robot = rb.buildRobotHead("Tin head").buildRobotTorso("Tin torso)...build();
    
    public void buildRobotHead();
    
    public void buildRobotTorso();
    
    public void buildRobotArms();
    
    public void buildRobotLegs();
    
    public Robot getRobot();
}
