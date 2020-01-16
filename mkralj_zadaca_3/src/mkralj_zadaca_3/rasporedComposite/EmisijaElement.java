package mkralj_zadaca_3.rasporedComposite;

import java.time.LocalDateTime;
import java.util.ArrayList;
import mkralj_zadaca_3.TVKuca;
import mkralj_zadaca_3.emisija.Emisija;
import mkralj_zadaca_3.emisija.EmisijaZaPrikaz;
import mkralj_zadaca_3.osoba.Osoba;
import mkralj_zadaca_3.osoba.Uloga;
import mkralj_zadaca_3.tablePrinter.EmisijaColumn;
import mkralj_zadaca_3.tablePrinter.IRow;
import mkralj_zadaca_3.visitor.ReklameVisitor;

public class EmisijaElement extends ProgramElement implements Comparable<EmisijaElement> {

    private EmisijaZaPrikaz emisijaZaPrikaz = null;

    public EmisijaElement(EmisijaZaPrikaz emisija) {
        this.emisijaZaPrikaz = emisija;
    }

    @Override
    public IRow display() {
        if (emisijaZaPrikaz != null) {
            row = new EmisijaColumn(row, emisijaZaPrikaz);
        }
        return row;
    }

    @Override
    public IRow displayVrstaEmisije(int idVrstaEmisije) {
        if(this.emisijaZaPrikaz.getEmisija().getVrstaEmisije().getVrstaId()==idVrstaEmisije)
            return display();
        
        return null;
    }

    @Override
    public boolean updateData() {
        emisijaZaPrikaz.updateData();
        Emisija em = emisijaZaPrikaz.getEmisija();
        if(em==null || em.getVrstaEmisije()==null)
            return false;
        
        this.emisijaZaPrikaz.setRedniBroj(TVKuca.getInstance().getNextRedniBroj());
        return true;
    }

    public EmisijaZaPrikaz getEmisija() {
        return this.emisijaZaPrikaz;
    }

    @Override
    public int compareTo(EmisijaElement arg0) {
        LocalDateTime pocetak1 = this.emisijaZaPrikaz.getPocetakEmisije();
        LocalDateTime pocetak2 = arg0.emisijaZaPrikaz.getPocetakEmisije();
        if (pocetak1 == null) {
            return 1;
        } else if (pocetak2 == null) {
            return -1;
        }

        return pocetak1.compareTo(pocetak2);
    }

    @Override
    public boolean promijeniUlogu(Osoba osoba, Uloga staraUloga, Uloga novaUloga) {
        if(emisijaZaPrikaz.update(osoba, staraUloga, novaUloga)){
            return true;
        }
            
        return false;
    }

    @Override
    public long izracunajPrihod() {
        ReklameVisitor visitor = new ReklameVisitor();
        return visitor.visit(emisijaZaPrikaz);
    }

    @Override
    public boolean izbrisiEmisiju(int redniBrojEmisije) {
        if(this.emisijaZaPrikaz.getRedniBroj()==redniBrojEmisije){
            emisijaZaPrikaz.unSubscribe();
            return true;
        }
            
        
        return false;
    }
    
    private EmisijaElement(EmisijaElement target) {
        if (target != null) {
            this.compositeCollection = new ArrayList<>();
            this.emisijaZaPrikaz = target.emisijaZaPrikaz.clone();
            for (RasporedComponent rC : target.compositeCollection) {
                this.compositeCollection.add(rC.clone());
            }
        }
    }

    @Override
    public RasporedComponent clone() {
        return new EmisijaElement(this);
    }

}
