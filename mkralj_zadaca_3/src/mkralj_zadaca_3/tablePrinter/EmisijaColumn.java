package mkralj_zadaca_3.tablePrinter;

import java.time.LocalDateTime;
import mkralj_zadaca_3.emisija.EmisijaZaPrikaz;
import mkralj_zadaca_3.osoba.Osoba;
import mkralj_zadaca_3.osoba.OsobaSUlogom;
import mkralj_zadaca_3.osoba.Uloga;

public class EmisijaColumn extends RowDecorator {

    private final EmisijaZaPrikaz emisijaZaPrikaz;
    private String data = "";

    public EmisijaColumn(IRow row, EmisijaZaPrikaz emisija) {
        super(row);
        this.emisijaZaPrikaz = emisija;

        addToRow();
    }

    @Override
    public String getDecoratorData() {
        return this.data;
    }

    private void addToRow() {
        LocalDateTime pocetakPrik = emisijaZaPrikaz.getPocetakEmisije();
        LocalDateTime zavrsetakPrik = emisijaZaPrikaz.getZavrsetakEmisije();
        data = String.format("|%4d|%-18s|%2d:%2d-%2d:%2d",
                this.emisijaZaPrikaz.getRedniBroj(), this.emisijaZaPrikaz.getEmisija().getNaziv()+"-"+this.emisijaZaPrikaz.getIdEmisija(), 
                pocetakPrik.getHour(), pocetakPrik.getMinute(),
                zavrsetakPrik.getHour(), zavrsetakPrik.getMinute()) + getSuradnici();
        
        super.addToRow(this, 2);

    }
    
        private String getSuradnici() {
        String returnMe = "";
        for (OsobaSUlogom suradnik : this.emisijaZaPrikaz.getSuradnici()) {
            Osoba o = suradnik.getOsoba();
            Uloga u = suradnik.getUloga();
            returnMe += String.format("|%4d-%-20s|%4d-%12s", o.getId(), o.getImePrezime(),
                    u.getId(), u.getOpis());
        }

        return returnMe;
    }

}
