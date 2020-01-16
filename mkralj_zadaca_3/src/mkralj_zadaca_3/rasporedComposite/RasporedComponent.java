package mkralj_zadaca_3.rasporedComposite;

import java.util.ArrayList;
import mkralj_zadaca_3.ICloneable;
import mkralj_zadaca_3.helpClasses.DanUTjednuHelper.Dan;
import mkralj_zadaca_3.iterator.Iterabl;
import mkralj_zadaca_3.iterator.Iterator;
import mkralj_zadaca_3.osoba.Osoba;
import mkralj_zadaca_3.osoba.Uloga;
import mkralj_zadaca_3.tablePrinter.IRow;


public abstract class RasporedComponent implements Iterabl<RasporedComponent>, ICloneable<RasporedComponent> {

    protected ArrayList<RasporedComponent> compositeCollection = new ArrayList<>();

    protected volatile static IRow row = null;

    public void add(RasporedComponent component) {
        throw new UnsupportedOperationException();
    }

    public RasporedComponent getLastChild() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean promijeniUlogu(Osoba osoba, Uloga staraUloga, Uloga novaUloga);

    public abstract IRow display();

    public abstract IRow displayVrstaEmisije(int idVrstaEmisije);

    public abstract boolean updateData();
    
    public RasporedComponent clone(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public IRow displayDanProgram(Dan d, int programId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int displayPrihodReklama(Dan dan, int program) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public RasporedComponent findDay(Dan d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void rasporedi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public abstract boolean izbrisiEmisiju(int redniBrojEmisije);

    @Override
    public Iterator<RasporedComponent> createIterator() {
        return new IteratorImplComponent();
    }

    class IteratorImplComponent implements Iterator<RasporedComponent> {

        private int currentPosition = 0;

        @Override
        public boolean hasNext() {
            if (compositeCollection == null || currentPosition >= compositeCollection.size()) {
                return false;
            }

            return true;
        }

        @Override
        public RasporedComponent next() {
            return compositeCollection.get(currentPosition++);
        }

        @Override
        public void remove() {
            if (currentPosition <= 0) {
                throw new IllegalStateException("Pozicija je manja od 0");
            }
            if (compositeCollection.get(currentPosition - 1) != null) {
                for (int i = currentPosition - 1; i < (compositeCollection.size() - 1); i++) {
                    compositeCollection.set(i, compositeCollection.get(i + 1));
                }

                compositeCollection.remove(compositeCollection.size() - 1);

                if (compositeCollection.size() == currentPosition && compositeCollection.size() > 0) {
                    currentPosition--;
                }
            }
        }

        @Override
        public void setPosition(int p) {
            this.currentPosition = p;
        }

        @Override
        public int getPosition() {
            return this.currentPosition;
        }
    }
}
