package mkralj_zadaca_3.chainOfResponsibility;

import java.util.ArrayList;
import java.util.Collections;
import mkralj_zadaca_3.emisija.Emisija;
import mkralj_zadaca_3.emisija.comparators.TrajanjeReklamaCompare;

public class SortByTrajanjeReklamaChain implements Chain {

    private Chain nextChain;

    @Override
    public void setNextChain(Chain chain) {
        this.nextChain = chain;
    }

    @Override
    public ArrayList<Emisija> sortList(ArrayList<Emisija> listaEmisija, SortBy sortBy, SortAs sortAs) {
        ArrayList<Emisija> returnMe = new ArrayList<>(listaEmisija);
        if (sortBy != SortBy.TRAJANJE_REKLAMA) {
            return nextChain.sortList(listaEmisija, sortBy, sortAs);
        }
        
        TrajanjeReklamaCompare trajanjeReklamaComparator = new TrajanjeReklamaCompare();
    
        if(sortAs==SortAs.ASC)
            Collections.sort(returnMe, trajanjeReklamaComparator);
        else
            Collections.sort(returnMe, trajanjeReklamaComparator.reversed());
        
        return returnMe;    
    }

}
