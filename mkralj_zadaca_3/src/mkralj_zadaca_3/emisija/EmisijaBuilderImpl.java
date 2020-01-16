package mkralj_zadaca_3.emisija;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import mkralj_zadaca_3.osoba.OsobaSUlogom;

public class EmisijaBuilderImpl implements EmisijaBuilder {
    
    private Emisija emisija;
    
    public EmisijaBuilderImpl(){
        emisija = new Emisija();
    }

    @Override
    public Emisija build() {
        return emisija;
    }

    @Override
    public EmisijaBuilder setId(int id) {
        this.emisija.setId(id);
        return this;
    }

    @Override
    public EmisijaBuilder setNaziv(String naziv) {
        this.emisija.setNaziv(naziv);
        return this;
    }

    @Override
    public EmisijaBuilder setTrajanje(int trajanjeMin) {
        this.emisija.setTrajanje(trajanjeMin);
        return this;
    }

    @Override
    public EmisijaBuilder setSuradnici(ArrayList<OsobaSUlogom> suradnici) {
        this.emisija.setSuradnici(suradnici);
        
        return this;
    }

    @Override
    public EmisijaBuilder addSuradnik(OsobaSUlogom suradnik) {
        this.emisija.addSuradnik(suradnik);
        
        return this;
    }

    @Override
    public EmisijaBuilder setVrsta(int vrsta) {
        this.emisija.setVrsta(vrsta);
        
        return this;
    }

    @Override
    public EmisijaBuilder setPocetak(LocalDateTime pocetak) {
        this.emisija.setPocetakEmisije(pocetak);
        
        return this;
    }

    
}
