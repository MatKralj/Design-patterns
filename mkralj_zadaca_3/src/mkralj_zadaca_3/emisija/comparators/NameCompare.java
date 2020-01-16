package mkralj_zadaca_3.emisija.comparators;

import java.util.Comparator;
import mkralj_zadaca_3.emisija.Emisija;

public class NameCompare implements Comparator<Emisija>{

    @Override
    public int compare(Emisija em1, Emisija em2) {
        if((em1==null && em2==null) || (em1.getNaziv()==null && em2.getNaziv()==null))
            return 0;
        else if(em1==null || em1.getNaziv()==null)
            return -1;
        else if(em2==null || em2.getNaziv()==null)
            return 1;
        
        return em1.getNaziv().compareToIgnoreCase(em2.getNaziv());
    }

    @Override
    public Comparator<Emisija> reversed() {
        return Comparator.super.reversed();
    }
    
}
