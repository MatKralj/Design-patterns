package mkralj_zadaca_3.chainOfResponsibility;

import java.util.ArrayList;
import java.util.Collections;
import mkralj_zadaca_3.emisija.Emisija;
import mkralj_zadaca_3.emisija.comparators.TrajanjeCompare;

public class SortByTrajanjeEmChain implements Chain {

    private Chain nextChain;

    @Override
    public void setNextChain(Chain chain) {
        this.nextChain = chain;
    }

    @Override
    public ArrayList<Emisija> sortList(ArrayList<Emisija> listaEmisija, SortBy sortBy, SortAs sortAs) {
        ArrayList<Emisija> returnMe = new ArrayList<>(listaEmisija);
        if (sortBy != SortBy.TRAJANJE_EM) {
            return nextChain.sortList(listaEmisija, sortBy, sortAs);
        }
        
        TrajanjeCompare trajanjeComparator = new TrajanjeCompare();
    
        if(sortAs==SortAs.ASC)
            Collections.sort(returnMe, trajanjeComparator);
        else
            Collections.sort(returnMe, trajanjeComparator.reversed());
        
        return returnMe;    
    }

}
