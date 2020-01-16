package mkralj_zadaca_3;

import java.util.ArrayList;
import mkralj_zadaca_3.helpClasses.DanUTjednuHelper.Dan;
import mkralj_zadaca_3.iterator.Iterator;
import mkralj_zadaca_3.memento.Caretaker;
import mkralj_zadaca_3.memento.Memento;
import mkralj_zadaca_3.osoba.Osoba;
import mkralj_zadaca_3.osoba.Uloga;
import mkralj_zadaca_3.rasporedComposite.RasporedComponent;
import mkralj_zadaca_3.tablePrinter.IRow;
import mkralj_zadaca_3.tablePrinter.Row;

public class TVKuca extends RasporedComponent {

    private volatile static TVKuca tvKuca = null;
    private volatile int zadnjiRedniBrojEmisije = 1;
    private volatile int idPohranjivanjaMementa = 1;
    private volatile Caretaker caretaker;

    private TVKuca() {
        compositeCollection = new ArrayList<>();
        caretaker = new Caretaker();
    }

    public static TVKuca getInstance() {
        if (tvKuca == null) {
            synchronized (TVKuca.class) {
                if (tvKuca == null) {
                    tvKuca = new TVKuca();
                }
            }
        }

        return tvKuca;
    }

    public int getNextRedniBroj() {
        return this.zadnjiRedniBrojEmisije++;
    }

    @Override
    public void rasporedi() {
        Iterator<RasporedComponent> iterator = super.createIterator();
        while (iterator.hasNext()) {
            iterator.next().rasporedi();
        }
    }

    @Override
    public RasporedComponent getLastChild() {
        Iterator<RasporedComponent> iterator = super.createIterator();
        RasporedComponent lastChild = null;
        while (iterator.hasNext()) {
            lastChild = iterator.next();
        }

        return lastChild;
    }

    @Override
    public void add(RasporedComponent component) {
        if (component != null) {
            this.compositeCollection.add(component);
        }
    }

    @Override
    public IRow display() {
        return row;
    }

    @Override
    public IRow displayVrstaEmisije(int idVrstaEmisije) {
        row = new Row();
        Iterator<RasporedComponent> iterator = super.createIterator();
        while (iterator.hasNext()) {
            iterator.next().displayVrstaEmisije(idVrstaEmisije);
        }
        return display();
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
    public IRow displayDanProgram(Dan d, int programId) {
        row = new Row();
        Iterator<RasporedComponent> iterator = super.createIterator();
        while (iterator.hasNext()) {
            iterator.next().displayDanProgram(d, programId);
        }
        return display();

    }

    @Override
    public int displayPrihodReklama(Dan d, int programId) {
        Iterator<RasporedComponent> iterator = super.createIterator();
        int returnMe = -1;
        while (iterator.hasNext()) {
            returnMe = iterator.next().displayPrihodReklama(d, programId);
            if (returnMe > 0) {
                return returnMe;
            }
        }
        return returnMe;
    }

    @Override
    public boolean izbrisiEmisiju(int redniBrojEmisije) {
        Iterator<RasporedComponent> iterator = super.createIterator();
        while (iterator.hasNext()) {
            Memento memento = storeInMemento();
            if (iterator.next().izbrisiEmisiju(redniBrojEmisije)) {
                caretaker.addMemento(memento);
                return true;
            }
        }
        return false;
    }

    public Memento storeInMemento() {
        return new Memento(getCompositeCopy(), idPohranjivanjaMementa++);
    }

    public String restoreFromMemento(int mementoNumber) {
        Memento mementoToRestoreFrom = caretaker.getSavedMemento(mementoNumber);
        if(mementoToRestoreFrom!=null){
            super.compositeCollection = new ArrayList<>(mementoToRestoreFrom.getSavedComponents());
            return "Podaci su vraceni";
        }
        
        return "Podaci nisu uspjesno vraceni";
    }
    
    public String getSavedInfo(){
        return caretaker.getMementosInfo();
    }

    private ArrayList<RasporedComponent> getCompositeCopy() {
        ArrayList<RasporedComponent> returnMe = new ArrayList<>();
        Iterator<RasporedComponent> iterator = super.createIterator();
        while (iterator.hasNext()) {
            returnMe.add(iterator.next().clone());
        }
        
        return returnMe;
    }
}
