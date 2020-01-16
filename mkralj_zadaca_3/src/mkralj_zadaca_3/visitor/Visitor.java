package mkralj_zadaca_3.visitor;

import mkralj_zadaca_3.emisija.EmisijaZaPrikaz;

public interface Visitor {
    public int visit(EmisijaZaPrikaz emisija);
}
