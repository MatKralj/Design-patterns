package mkralj_zadaca_3.emisija;

import mkralj_zadaca_3.osoba.Osoba;
import mkralj_zadaca_3.osoba.Uloga;

public interface Observer {
    public boolean update(Osoba osoba, Uloga staraUloga, Uloga novaUloga);
    public void subscribe();
    public void unSubscribe();
}
