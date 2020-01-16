package mkralj_zadaca_3.emisija.comparators;

import java.util.Comparator;
import mkralj_zadaca_3.emisija.Emisija;

public class TrajanjeCompare implements Comparator<Emisija>{

    @Override
    public int compare(Emisija em1, Emisija em2) {
        if(em1==null && em2==null)
            return 0;
        else if(em1==null)
            return -1;
        else if(em2==null)
            return 1;
        
        if(em1.getTrajanje() < em2.getTrajanje())
            return -1;
        else if (em1.getTrajanje()>em2.getTrajanje())
            return 1;
        else return 0;
    }

    @Override
    public Comparator<Emisija> reversed() {
        return Comparator.super.reversed();
    }
    
}
