package designpatternsmediator.abstractions;

public interface Mediator {
    
    public void saleOffer(String stock, int shares, int collCode);
    public void buyOffer(String stock, int shares, int collCode);
    public void addColleague(Colleague col);
    public void printStockOfferings();
}
