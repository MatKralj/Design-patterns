package designpatternstemplate.implementation;

import designpatternstemplate.abstraction.Hoagie;

public class VeggieHoagie extends Hoagie {

    private String[] vegsUsed = {"Lettuce", "Tomatoes", "Onions", "Sweet Peppers"};
    private String[] condimentsUsed = {"Oil", "Vineagar"};

    @Override
    public boolean customerWantsCheese() {
        return false;
    }

    @Override
    public boolean customerWantsMeat() {
        return false;
    }

    
    @Override
    public void addMeat() {
        
    }

    @Override
    public void addCheese() {

    }

    @Override
    public void addVeg() {
        System.out.println("Adding the Veggies");

        for (String veg : vegsUsed) {
            System.out.print(veg + " ");
        }
        System.out.println("");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding the Condiments");

        for (String condiment : condimentsUsed) {
            System.out.print(condiment + " ");
        }
        System.out.println("");
    }

}
