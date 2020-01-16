package mkralj_zadaca_3.emisija.comparators;

import java.util.Comparator;
import mkralj_zadaca_3.emisija.Emisija;

public class TrajanjeReklamaCompare implements Comparator<Emisija>{

    @Override
    public int compare(Emisija em1, Emisija em2) {
        if((em1==null && em2==null) || (em1.getVrstaEmisije()==null && em2.getVrstaEmisije()==null))
            return 0;
        else if(em1==null || em1.getVrstaEmisije()==null)
            return -1;
        else if(em2==null || em2.getVrstaEmisije()==null)
            return 1;
        
        int trajanjeReklama1 = em1.getVrstaEmisije().getMaxTrajanjeReklama();
        int trajanjeReklama2 = em2.getVrstaEmisije().getMaxTrajanjeReklama();
        if(trajanjeReklama1<trajanjeReklama2)
            return -1;
        else if(trajanjeReklama1>trajanjeReklama2)
            return 1;
        else return 0;
    }

    @Override
    public Comparator<Emisija> reversed() {
        return Comparator.super.reversed();
    }
    
}
