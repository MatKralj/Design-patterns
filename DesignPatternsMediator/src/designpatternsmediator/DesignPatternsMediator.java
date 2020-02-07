package designpatternsmediator;

import designpatternsmediator.abstractions.Mediator;
import designpatternsmediator.implementations.colleague.GormanSlacks;
import designpatternsmediator.implementations.colleague.JTPoorman;
import designpatternsmediator.implementations.mediator.StockMediator;

public class DesignPatternsMediator {

    public static void main(String[] args) {
       
        Mediator nyse = new StockMediator();
        
        GormanSlacks broker = new GormanSlacks(nyse);
        JTPoorman broker2 = new JTPoorman(nyse);
        
        broker.saleOffer("MSFT", 100);
        broker.saleOffer("GOOG", 50);
        
        broker2.buyOffer("MSFT", 100);
        broker2.saleOffer("NRG", 10);
        broker2.buyOffer("GOOG", 10);
        
        broker.buyOffer("NRG", 10);
        
        nyse.printStockOfferings();
    }
    
}
