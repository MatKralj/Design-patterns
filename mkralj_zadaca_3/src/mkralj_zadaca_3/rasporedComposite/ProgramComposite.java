package mkralj_zadaca_3.rasporedComposite;

import java.util.ArrayList;
import mkralj_zadaca_3.helpClasses.DanUTjednuHelper;
import mkralj_zadaca_3.iterator.Iterator;
import mkralj_zadaca_3.osoba.Osoba;
import mkralj_zadaca_3.osoba.Uloga;
import mkralj_zadaca_3.program.Program;
import mkralj_zadaca_3.tablePrinter.IRow;
import mkralj_zadaca_3.tablePrinter.ProgramColumn;

public class ProgramComposite extends RasporedComponent {

    private Program program = null;

    public ProgramComposite(Program p) {
        compositeCollection = new ArrayList<>();
        this.program = p;
    }

    @Override
    public void add(RasporedComponent component) {
        if (component != null) {
            if (component instanceof DanElementComposite) {
                ((DanElementComposite) component).setParent(this);
            }
            this.compositeCollection.add(component);
        }
    }

    public Program getProgram() {
        return program;
    }

    @Override
    public IRow display() {
        Iterator<RasporedComponent> iterator = super.createIterator();
        while (iterator.hasNext()) {
            iterator.next().display();
        }

        return row;
    }

    @Override
    public IRow displayVrstaEmisije(int idVrstaEmisije) {
        row = new ProgramColumn(row, program);
        Iterator<RasporedComponent> iterator = super.createIterator();
        while (iterator.hasNext()) {
            iterator.next().displayVrstaEmisije(idVrstaEmisije);
        }

        return row;
    }

    @Override
    public RasporedComponent getLastChild() {
        RasporedComponent returnMe = null;

        Iterator<RasporedComponent> iterator = super.createIterator();
        while (iterator.hasNext()) {
            returnMe = iterator.next();
        }
        return returnMe;
    }

    @Override
    public RasporedComponent findDay(DanUTjednuHelper.Dan d) {
        Iterator<RasporedComponent> iterator = super.createIterator();
        while (iterator.hasNext()) {
            RasporedComponent currentComp = iterator.next();
            if (currentComp instanceof DanElementComposite) {
                if (((DanElementComposite) currentComp).danIs(d)) {
                    return (DanElementComposite) currentComp;
                }
            }
        }

        DanElementComposite returnMe = new DanElementComposite(d);
        this.add(returnMe);

        return returnMe;
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
    public void rasporedi() {
        Iterator<RasporedComponent> iterator = super.createIterator();
        while (iterator.hasNext()) {
            iterator.next().rasporedi();
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
    public IRow displayDanProgram(DanUTjednuHelper.Dan d, int programId) {
        if (this.program.getIdProgram() == programId) {
            RasporedComponent rCompDan = this.findDay(d);
            if (rCompDan != null) {
                row = new ProgramColumn(row, program);
                return rCompDan.display();
            }
        }
        return row;
    }

    @Override
    public int displayPrihodReklama(DanUTjednuHelper.Dan dan, int programId) {
        int prihod = 0;
        if (this.program.getIdProgram() == programId) {
            RasporedComponent rCompDan = this.findDay(dan);
            if (rCompDan != null && (rCompDan instanceof DanElementComposite)) {
                prihod += ((DanElementComposite) rCompDan).izracunajPrihod();
            }
        }

        return prihod;
    }

    @Override
    public boolean izbrisiEmisiju(int redniBrojEmisije) {
        Iterator<RasporedComponent> iterator = super.createIterator();
        while (iterator.hasNext()) {
            if (iterator.next().izbrisiEmisiju(redniBrojEmisije)) {
                return true;
            }
        }
        return false;
    }

    private ProgramComposite(ProgramComposite target) {
        if (target != null) {
            this.compositeCollection = new ArrayList<>();
            this.program = target.program;
            for (RasporedComponent rC : target.compositeCollection) {
                this.compositeCollection.add(rC.clone());
            }
        }
    }

    @Override
    public RasporedComponent clone() {
        return new ProgramComposite(this);
    }

}
