package mkralj_zadaca_3.osoba;

import java.util.ArrayList;
import mkralj_zadaca_3.ICloneable;
import mkralj_zadaca_3.IData;
import mkralj_zadaca_3.LoadedData;
import mkralj_zadaca_3.emisija.Observer;
import mkralj_zadaca_3.helpClasses.ErrorTracker;

public class OsobaSUlogom implements IData, Subject, ICloneable<OsobaSUlogom> {

    private int idOsoba = -1;
    private int idUloga = -1;
    private Osoba osoba = null;
    private Uloga uloga = null;
    private ArrayList<Observer> observers;

    public OsobaSUlogom(int idOsoba, int idUloga) {
        this.idOsoba = idOsoba;
        this.idUloga = idUloga;
        observers = new ArrayList<>();
    }

    private OsobaSUlogom(OsobaSUlogom target) {
        if(this!=null){
            this.idOsoba = target.idOsoba;
            this.idUloga = target.idUloga;
            this.osoba = target.osoba.clone();
            this.uloga = target.uloga.clone();
            this.observers = target.observers;
        }
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public Uloga getUloga() {
        return uloga;
    }

    @Override
    public boolean updateData() {
        LoadedData ld = LoadedData.getInstance();

        if (!updateOsoba(ld)) {
            return false;
        }
        if (!updateDataUloga(ld)) {
            return false;
        }

        return true;
    }

    private boolean updateDataUloga(LoadedData ld) {
        ArrayList<Uloga> uloge = ld.getUloge();
        for (Uloga u : uloge) {
            if (u.getId() == this.idUloga) {
                this.uloga = u;
                return true;
            }
        }
        ErrorTracker.getTracker().addErrorTrack("Osoba s ulogom koja ima id: " + this.idUloga + " ne postoji.");
        return false;
    }

    private boolean updateOsoba(LoadedData ld) {
        ArrayList<Osoba> osobe = ld.getOsobe();
        for (Osoba o : osobe) {
            if (o.getId() == this.idOsoba) {
                this.osoba = o;
                return true;
            }
        }
        ErrorTracker.getTracker().addErrorTrack("Osoba ima id: " + this.idOsoba + " ne postoji.");
        return false;
    }
    
    public void updateUloga(Uloga novaUloga){
        this.idUloga = novaUloga.getId();
        Uloga staraUloga = this.uloga;
        this.uloga = novaUloga;
        
        notifyObservers(staraUloga);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if (index >= 0) {
            this.observers.remove(index);
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        if(observer!=null)
            observers.add(observer);
    }

    @Override
    public void notifyObservers(Uloga staraUloga) {
        for(Observer observer : observers){
            observer.update(osoba, staraUloga, uloga);
        }
    }

    @Override
    public String toString() {
        return "OsobaSUlogom{" + "osoba=" + osoba.getImePrezime() + ", uloga=" + uloga.getOpis() + '}';
    }

    @Override
    public OsobaSUlogom clone() {
        return new OsobaSUlogom(this);
    }

    
}
