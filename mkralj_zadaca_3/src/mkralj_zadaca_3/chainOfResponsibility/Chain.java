package mkralj_zadaca_3.chainOfResponsibility;

import java.util.ArrayList;
import mkralj_zadaca_3.emisija.Emisija;

public interface Chain {
    public void setNextChain(Chain chain);
    
    public ArrayList<Emisija> sortList(ArrayList<Emisija> listaEmisija, SortBy sortBy, SortAs sortAs);
    
    public enum SortBy{
        IME,
        TRAJANJE_EM,
        TRAJANJE_REKLAMA,
        VRSTA_EMISIJE
    }
    
    public enum SortAs{
        ASC,
        DESC
    }
}
