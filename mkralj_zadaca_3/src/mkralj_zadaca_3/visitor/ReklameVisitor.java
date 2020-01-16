package mkralj_zadaca_3.visitor;

import mkralj_zadaca_3.emisija.EmisijaZaPrikaz;

public class ReklameVisitor implements Visitor{

    @Override
    public int visit(EmisijaZaPrikaz emisija) {
        return emisija.getEmisija().getVrstaEmisije().getMaxTrajanjeReklama();
    }
    
}
