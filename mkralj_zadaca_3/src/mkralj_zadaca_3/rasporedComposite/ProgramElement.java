package mkralj_zadaca_3.rasporedComposite;

import mkralj_zadaca_3.tablePrinter.IRow;

public abstract class ProgramElement extends RasporedComponent{

    public void add(ProgramElement component) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public abstract IRow display();
    
    public void setParent(RasporedComponent parent){
        throw new UnsupportedOperationException();
    }
    
    public abstract long izracunajPrihod();
}
