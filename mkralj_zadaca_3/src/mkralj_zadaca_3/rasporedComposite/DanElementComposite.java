package mkralj_zadaca_3.rasporedComposite;

import java.time.LocalDateTime;
import java.util.ArrayList;
import mkralj_zadaca_3.emisija.EmisijaZaPrikaz;
import mkralj_zadaca_3.helpClasses.DanUTjednuHelper.Dan;
import mkralj_zadaca_3.helpClasses.RasporedHelper;
import mkralj_zadaca_3.iterator.Iterator;
import mkralj_zadaca_3.osoba.Osoba;
import mkralj_zadaca_3.osoba.Uloga;
import mkralj_zadaca_3.program.Program;
import static mkralj_zadaca_3.rasporedComposite.RasporedComponent.row;
import mkralj_zadaca_3.tablePrinter.DanColumn;
import mkralj_zadaca_3.tablePrinter.IRow;

public class DanElementComposite extends ProgramElement {

    private Dan dan = null;
    private RasporedComponent parent = null;

    public DanElementComposite(Dan dan) {
        this.dan = dan;
        compositeCollection = new ArrayList<>();
    }

    @Override
    public void add(ProgramElement component) {
        if (component != null) {
            this.compositeCollection.add(component);
        }
    }

    @Override
    public IRow display() {
        if (this.dan == null || this.dan == Dan.NULL) {
            return null;
        }

        row = new DanColumn(row, dan);

        Iterator<RasporedComponent> iterator = super.createIterator();
        while (iterator.hasNext()) {
            iterator.next().display();
        }
        
        return row;
    }

    @Override
    public IRow displayVrstaEmisije(int idVrstaEmisije) {
        if (this.dan == null || this.dan == Dan.NULL) {
            return null;
        }
        if (this.dan != null && this.compositeCollection != null && !this.compositeCollection.isEmpty()) {
            row = new DanColumn(row, dan);
            Iterator<RasporedComponent> iterator = super.createIterator();
            while (iterator.hasNext()) {
                iterator.next().displayVrstaEmisije(idVrstaEmisije);
            }
        }
        
        return row;
    }

    protected boolean danIs(Dan d) {
        if (d != null) {
            return d.getValue() == this.dan.getValue();
        }

        return false;
    }

    @Override
    public boolean updateData() {
        Iterator<RasporedComponent> iterator = super.createIterator();
        while (iterator.hasNext()) {
            if (!iterator.next().updateData()) {
                iterator.remove();
            }
        }

        return true;
    }

    @Override
    public void setParent(RasporedComponent parent) {
        this.parent = parent;
    }

    public ArrayList<RasporedComponent> getElementiPrograma() {
        return compositeCollection;
    }

    @Override
    public void rasporedi() {
        if (dan.equals(Dan.NULL)) {
            return;
        }

        izbaciEmisijeIzvanOkviraPrograma();
        izbaciEmisijuZbogPreklapanja();
        try {
            RasporedHelper rHelper = new RasporedHelper((ProgramComposite) parent, dan, compositeCollection);
            rHelper.rasporediEmisije();
        } catch (Exception ex) {

        }
    }

    private boolean imaPreklapanja(EmisijaZaPrikaz emisija, EmisijaZaPrikaz emisija2) {
        if (emisija2.getPocetakEmisije() == null) {
            return false;
        }

        if ((emisija.getZavrsetakEmisije().isBefore(emisija2.getPocetakEmisije()) || emisija.getZavrsetakEmisije().equals(emisija2.getPocetakEmisije()))
                || (emisija.getPocetakEmisije().isAfter(emisija2.getZavrsetakEmisije()) || emisija.getPocetakEmisije().equals(emisija2.getZavrsetakEmisije()))) {
            return false;
        }

        System.out.println("Bilo je preklapanja: " + emisija.toString() + " i " + emisija2.toString() + " u danu: " + this.dan);
        return true;
    }

    private boolean emisijaUnutarOkviraPrograma(EmisijaZaPrikaz emisija) {
        if (parent instanceof ProgramComposite) {
            try {
                Program prog = ((ProgramComposite) parent).getProgram();
                LocalDateTime pocetakPr = prog.getPocetakPrikazivanjaProg();
                LocalDateTime krajPr = prog.getZavrsetakPrikazivanjaProg();

                if (pocetakPr.isBefore(emisija.getPocetakEmisije()) && krajPr.isAfter(emisija.getZavrsetakEmisije())) {
                    return true;
                }

                return false;
            } catch (Exception ex) {
                return true;
            }
        }
        return true;
    }

    private void izbaciEmisijeIzvanOkviraPrograma() {
        Iterator<RasporedComponent> iterator = super.createIterator();

        while (iterator.hasNext()) {
            ProgramElement curElemEmisija = ((ProgramElement) iterator.next());
            if (curElemEmisija instanceof EmisijaElement) {
                EmisijaZaPrikaz emisijaPrikaz = ((EmisijaElement) curElemEmisija).getEmisija();
                if (!emisijaUnutarOkviraPrograma(emisijaPrikaz)) {
                    System.out.println("Emisija nije unutar okvira programa: " + emisijaPrikaz.getEmisija().toString());
                    iterator.remove();
                }
            }
        }
    }

    private void izbaciEmisijuZbogPreklapanja() {
        Iterator<RasporedComponent> iterator = super.createIterator();
        while (iterator.hasNext()) {
            ProgramElement curElemEmisija = ((ProgramElement) iterator.next());
            int pos = iterator.getPosition();
            EmisijaZaPrikaz emisijaZaPrikaz1 = ((EmisijaElement) curElemEmisija).getEmisija();

            if (emisijaZaPrikaz1.getPocetakEmisije() != null) {
                while (iterator.hasNext()) {
                    ProgramElement curElemEmisija2 = ((ProgramElement) iterator.next());

                    if (curElemEmisija2 instanceof EmisijaElement) {
                        EmisijaZaPrikaz emisijaZaPrikaz2 = ((EmisijaElement) curElemEmisija2).getEmisija();
                        if (imaPreklapanja(emisijaZaPrikaz1, emisijaZaPrikaz2)) {
                            iterator.remove();
                        }
                    }
                }
                iterator.setPosition(pos);
            }

        }
    }

    @Override
    public boolean promijeniUlogu(Osoba osoba, Uloga staraUloga, Uloga novaUloga) {
        boolean promjena = false;
        Iterator<RasporedComponent> iterator = super.createIterator();
        while (iterator.hasNext()) {
            if (iterator.next().promijeniUlogu(osoba, staraUloga, novaUloga)) {
                promjena = true;
            }
        }

        return promjena;
    }

    @Override
    public long izracunajPrihod() {
        Iterator<RasporedComponent> iterator = super.createIterator();
        long prihod = 0;
        while (iterator.hasNext()) {
            prihod += ((ProgramElement) iterator.next()).izracunajPrihod();
        }
        return prihod;
    }

    @Override
    public boolean izbrisiEmisiju(int redniBrojEmisije) {
        Iterator<RasporedComponent> iterator = super.createIterator();
        while (iterator.hasNext()) {
            if (iterator.next().izbrisiEmisiju(redniBrojEmisije)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    
    private DanElementComposite(DanElementComposite target) {
        if (target != null) {
            this.compositeCollection = new ArrayList<>();
            this.dan = target.dan;
            this.parent = target.parent;
            for (RasporedComponent rC : target.compositeCollection) {
                this.compositeCollection.add(rC.clone());
            }
        }
    }

    @Override
    public RasporedComponent clone() {
        return new DanElementComposite(this);
    }

}
