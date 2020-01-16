package mkralj_zadaca_3;

import mkralj_zadaca_3.osoba.Uloga;
import mkralj_zadaca_3.osoba.Osoba;
import java.util.ArrayList;
import mkralj_zadaca_3.emisija.Emisija;
import mkralj_zadaca_3.emisija.vrstaEmisije.VrstaEmisije;

public class LoadedData {

    private volatile static LoadedData loadedData = null;

    private ArrayList<Emisija> emisije = null;
    private ArrayList<Osoba> osobe = null;
    private ArrayList<Uloga> uloge = null;
    private ArrayList<VrstaEmisije> vrsteEmisija = null;

    public static LoadedData getInstance() {
        if (loadedData == null) {
            synchronized (LoadedData.class) {
                if (loadedData == null) {
                    loadedData = new LoadedData();
                }
            }
        }

        return loadedData;
    }

    private LoadedData() {}

    public ArrayList<Emisija> getEmisije() {
        return emisije;
    }

    public void setEmisije(ArrayList<Emisija> emisije) {
        this.emisije = emisije;
    }

    public ArrayList<Osoba> getOsobe() {
        return osobe;
    }

    public void setOsobe(ArrayList<Osoba> osobe) {
        this.osobe = osobe;
    }

    public ArrayList<Uloga> getUloge() {
        return uloge;
    }

    public void setUloge(ArrayList<Uloga> uloge) {
        this.uloge = uloge;
    }

    public ArrayList<VrstaEmisije> getVrsteEmisija() {
        return this.vrsteEmisija;
    }

    public void setVrsteEmisija(ArrayList<VrstaEmisije> vrsteEmisija) {
        this.vrsteEmisija = vrsteEmisija;
    }

    void updateData() {
        for(Emisija e : emisije)
        {
            e.updateData();
        }
        for(VrstaEmisije o : this.vrsteEmisija)
        {
            o.updateData();
        }
    }
}
