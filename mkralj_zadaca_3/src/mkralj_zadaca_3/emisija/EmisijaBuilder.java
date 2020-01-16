package mkralj_zadaca_3.emisija;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import mkralj_zadaca_3.osoba.OsobaSUlogom;

public interface EmisijaBuilder {
    public Emisija build();
    public EmisijaBuilder setId(final int id);
    public EmisijaBuilder setNaziv(final String naziv);
    public EmisijaBuilder setTrajanje(final int trajanjeMin);
    public EmisijaBuilder setPocetak(final LocalDateTime pocetak);
    public EmisijaBuilder setSuradnici(ArrayList<OsobaSUlogom> suradnici);
    public EmisijaBuilder addSuradnik(OsobaSUlogom suradnik);
    public EmisijaBuilder setVrsta(int vrsta);
}
