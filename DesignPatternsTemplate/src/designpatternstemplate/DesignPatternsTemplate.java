package designpatternstemplate;

import designpatternstemplate.abstraction.Hoagie;
import designpatternstemplate.implementation.ItalianHoagie;
import designpatternstemplate.implementation.VeggieHoagie;

public class DesignPatternsTemplate {

    public static void main(String[] args) {
        
        Hoagie sMesom = new ItalianHoagie();
        sMesom.makeSandwich();
        Hoagie vege = new VeggieHoagie();
        vege.makeSandwich();
    }
}
