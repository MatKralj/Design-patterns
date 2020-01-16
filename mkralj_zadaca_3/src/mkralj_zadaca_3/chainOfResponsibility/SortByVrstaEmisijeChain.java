package mkralj_zadaca_3.chainOfResponsibility;

import java.util.ArrayList;
import java.util.Collections;
import mkralj_zadaca_3.emisija.Emisija;
import mkralj_zadaca_3.emisija.comparators.VrstaEmisijeCompare;

public class SortByVrstaEmisijeChain implements Chain {

    private Chain nextChain;

    @Override
    public void setNextChain(Chain chain) {
        this.nextChain = chain;
    }

    @Override
    public ArrayList<Emisija> sortList(ArrayList<Emisija> listaEmisija, SortBy sortBy, SortAs sortAs) {
        ArrayList<Emisija> returnMe = new ArrayList<>(listaEmisija);
        if (sortBy != SortBy.VRSTA_EMISIJE) {
            return listaEmisija;
        }
        
        VrstaEmisijeCompare vrstaEmisijeComparator = new VrstaEmisijeCompare();
    
        if(sortAs==SortAs.ASC)
            Collections.sort(returnMe, vrstaEmisijeComparator);
        else
            Collections.sort(returnMe, vrstaEmisijeComparator.reversed());
        
        return returnMe;    
    }

}
