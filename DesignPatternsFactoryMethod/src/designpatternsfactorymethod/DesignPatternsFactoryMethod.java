package designpatternsfactorymethod;

import designpatternsfactorymethod.abstractClasses.EnemyShip;
import designpatternsfactorymethod.concreteClasses.EnemyShipFactory;
import java.util.Scanner;

public class DesignPatternsFactoryMethod {

    public static void main(String[] args) {
        
        EnemyShipFactory factory = new EnemyShipFactory();
        EnemyShip theEnemy = null;
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("What type of ship? (U / R/ B)");
        if(userInput.hasNext()){
            String typeOfShip = userInput.nextLine();
            
            theEnemy = factory.makeEnemyShip(typeOfShip);
        }
        if(theEnemy!=null)
            doStuffEnemy(theEnemy);
        else
            System.out.println("Try using (U / R / B) letters");
    }

    private static void doStuffEnemy(EnemyShip ufoShip) {
        ufoShip.displayEnemyShip();
        ufoShip.followHeroShip();
        ufoShip.enemyShipShoots();
    }
    
}
