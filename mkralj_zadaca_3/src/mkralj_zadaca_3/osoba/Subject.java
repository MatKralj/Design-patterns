package mkralj_zadaca_3.osoba;

import mkralj_zadaca_3.emisija.Observer;

public interface Subject {
 
    public void removeObserver(Observer observer);
    public void registerObserver(Observer observer);
    public void notifyObservers(Uloga staraUloga);
}
