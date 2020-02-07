package designpatternstemplate.implementation;

import designpatternstemplate.abstraction.Hoagie;

public class ItalianHoagie extends Hoagie {

    private String[] meatUsed = {"Salami", "Pepperoni", "Capicola Ham"};
    private String[] cheeseUsed = {"Provolone"};
    private String[] vegsUsed = {"Lettuce", "Tomatoes", "Onions", "Sweet Peppers"};
    private String[] condimentsUsed = {"Oil", "Vineagar"};

    @Override
    public void addMeat() {
        System.out.println("Adding the meat");

        for (String meat : meatUsed) {
            System.out.print(meat + " ");
        }
        System.out.println("");
    }

    @Override
    public void addCheese() {
        System.out.println("Adding the cheese");

        for (String cheese : cheeseUsed) {
            System.out.print(cheese + " ");
        }
        System.out.println("");
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
