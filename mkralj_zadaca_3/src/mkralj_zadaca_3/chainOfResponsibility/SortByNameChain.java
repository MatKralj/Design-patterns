package mkralj_zadaca_3.chainOfResponsibility;

import java.util.ArrayList;
import java.util.Collections;
import mkralj_zadaca_3.emisija.Emisija;
import mkralj_zadaca_3.emisija.comparators.NameCompare;

public class SortByNameChain implements Chain {

    private Chain nextChain;

    @Override
    public void setNextChain(Chain chain) {
        this.nextChain = chain;
    }

    @Override
    public ArrayList<Emisija> sortList(ArrayList<Emisija> listaEmisija, SortBy sortBy, SortAs sortAs) {
        ArrayList<Emisija> returnMe = new ArrayList<>(listaEmisija);
        if (sortBy != SortBy.IME) {
            return nextChain.sortList(listaEmisija, sortBy, sortAs);
        }
        
        NameCompare nameComparator = new NameCompare();
    
        if(sortAs==SortAs.ASC)
            Collections.sort(returnMe, nameComparator);
        else
            Collections.sort(returnMe, nameComparator.reversed());
        
        return returnMe;    
    }

}
