package mkralj_zadaca_3.chainOfResponsibility;

import java.util.ArrayList;
import mkralj_zadaca_3.LoadedData;
import mkralj_zadaca_3.chainOfResponsibility.Chain.SortAs;
import mkralj_zadaca_3.chainOfResponsibility.Chain.SortBy;
import mkralj_zadaca_3.emisija.Emisija;

public class ChainOfResponsibility {

    private final ArrayList<Emisija> listToSort;
    private final SortAs sortAs;
    private final SortBy sortBy;
    private final SortByNameChain sortByNameChain;
    private final SortByTrajanjeEmChain sortByTrajanjeEmChain;
    private final SortByTrajanjeReklamaChain sortByTrajanjeReklamaChain;
    private final SortByVrstaEmisijeChain sortByVrstaEmisijeChain;
      
    public ChainOfResponsibility(SortBy sortBy, SortAs sortAs){
        this.listToSort = LoadedData.getInstance().getEmisije();
        this.sortBy = sortBy;
        this.sortAs = sortAs;
        
        this.sortByNameChain = new SortByNameChain();
        this.sortByTrajanjeEmChain = new SortByTrajanjeEmChain();
        this.sortByTrajanjeReklamaChain = new SortByTrajanjeReklamaChain();
        this.sortByVrstaEmisijeChain = new SortByVrstaEmisijeChain();
        
        this.sortByNameChain.setNextChain(sortByTrajanjeEmChain);
        this.sortByTrajanjeEmChain.setNextChain(sortByTrajanjeReklamaChain);
        this.sortByTrajanjeReklamaChain.setNextChain(sortByVrstaEmisijeChain);
    }
    
    public ArrayList<Emisija> sort(){
        return this.sortByNameChain.sortList(listToSort, sortBy, sortAs);
    }
}
