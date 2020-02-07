package designpatternsmediator.implementations.mediator;

import designpatternsmediator.abstractions.Colleague;
import designpatternsmediator.abstractions.Mediator;
import designpatternsmediator.implementations.StockOffer;
import java.util.ArrayList;

public class StockMediator implements Mediator {

    private ArrayList<Colleague> colleagues;
    private ArrayList<StockOffer> stockBuyOffers;
    private ArrayList<StockOffer> stockSellOffers;

    private int colleagueCodes = 0;

    public StockMediator() {
        colleagues = new ArrayList<>();
        stockBuyOffers = new ArrayList<>();
        stockSellOffers = new ArrayList<>();
    }

    @Override
    public void saleOffer(String stock, int shares, int collCode) {
        boolean stockSold = false;
        for (StockOffer offer : stockBuyOffers) {
            if (offer.getStockSymbol().equals(stock) && offer.getStockShares() == shares) {
                System.out.println(shares + " shares of " + stock + " sold to colleague code " + offer.getColleagueCode());

                stockBuyOffers.remove(offer);
                stockSold = true;
                break;
            }
        }
        if (!stockSold) {
            System.out.println(shares + "share of " + stock + " added to inventory");
            StockOffer offering = new StockOffer(shares, stock, collCode);
            stockSellOffers.add(offering);
        }
    }

    @Override
    public void buyOffer(String stock, int shares, int collCode) {
        boolean stockBought = false;
        for (StockOffer offer : stockSellOffers) {
            if (offer.getStockSymbol().equals(stock) && offer.getStockShares() == shares) {
                System.out.println(shares + " shares of " + stock + " bought by colleague code " + offer.getColleagueCode());

                stockSellOffers.remove(offer);
                stockBought = true;
                break;
            }
        }
        if (!stockBought) {
            System.out.println(shares + "share of " + stock + " added to inventory");
            StockOffer offering = new StockOffer(shares, stock, collCode);
            stockBuyOffers.add(offering);
        }
    }

    @Override
    public void addColleague(Colleague col) {
        colleagueCodes++;
        col.setColleagueCode(colleagueCodes);
        colleagues.add(col);
    }
    
    public void printStockOfferings(){
        System.out.println("\nStocks for Sale");
        for(StockOffer offer : stockSellOffers){
            System.out.println(offer.getStockShares()+" of "+offer.getStockSymbol());
        }
        
        System.out.println("\nStocks Buy Offers");
        for(StockOffer offer : stockBuyOffers){
            System.out.println(offer.getStockShares()+" of "+offer.getStockSymbol());
        }
    }

}
