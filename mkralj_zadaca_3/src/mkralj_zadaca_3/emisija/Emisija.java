package mkralj_zadaca_3.emisija;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import mkralj_zadaca_3.IData;
import mkralj_zadaca_3.LoadedData;
import mkralj_zadaca_3.emisija.vrstaEmisije.VrstaEmisije;
import mkralj_zadaca_3.osoba.OsobaSUlogom;

public class Emisija implements IData {

    private int id;
    private String naziv;
    private VrstaEmisije vrstaEmisije;
    private int trajanje;
    private volatile ArrayList<OsobaSUlogom> suradnici;

    private LocalDateTime pocetakEmisije;
    private LocalDateTime zavrsetakEmisije;

    public Emisija() {
        suradnici = new ArrayList<>();
    }

    public LocalDateTime getPocetakEmisije() {
        return pocetakEmisije;
    }

    public LocalDateTime getZavrsetakEmisije() {
        return zavrsetakEmisije;
    }

    public void setPocetakEmisije(LocalDateTime pocetakEmisije) {
        this.pocetakEmisije = pocetakEmisije;
        this.zavrsetakEmisije = pocetakEmisije;

        if (pocetakEmisije != null) {
            zavrsetakEmisije = zavrsetakEmisije.plusMinutes(trajanje);
        }
    }

    public int getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public ArrayList<OsobaSUlogom> getSuradnici() {
        return suradnici;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setTrajanje(int trajanjeMin) {
        this.trajanje = trajanjeMin;
    }

    public void addSuradnik(OsobaSUlogom suradnik) {
        this.suradnici.add(suradnik);
    }

    public void setSuradnici(ArrayList<OsobaSUlogom> suradnici) {
        if (suradnici != null) {
            this.suradnici.addAll(suradnici);
        }
    }

    @Override
    public boolean updateData() {
        getPodaciEmisije();
        updateSuradnici();
        vrstaEmisijeUpdate();
        for (OsobaSUlogom suradnik : this.suradnici) {
            suradnik.updateData();
        }
        return true;
    }

    @Override
    public String toString() {
        try {
            String suradniciStr = "";
            for (OsobaSUlogom oSU : this.suradnici) {
                suradniciStr += oSU.toString();
            }
            return "Emisija: " + this.naziv
                    + " Trajanje: " + this.trajanje + " Pocetak emisije: " + this.pocetakEmisije.format(DateTimeFormatter.ISO_LOCAL_TIME)
                    + " Zavrsetak: " + this.zavrsetakEmisije.format(DateTimeFormatter.ISO_LOCAL_TIME) + suradniciStr;
        } catch (Exception ex) {
            return "Emisija: " + this.naziv
                    + " Trajanje: " + this.trajanje + " Pocetak emisije: " + this.pocetakEmisije
                    + " Zavrsetak: " + this.zavrsetakEmisije;
        }
    }

    public void setVrsta(int vrsta) {
        this.vrstaEmisije = new VrstaEmisije(vrsta);
    }

    public VrstaEmisije getVrstaEmisije() {
        return vrstaEmisije;
    }

    private void getPodaciEmisije() {
        ArrayList<Emisija> emisije = LoadedData.getInstance().getEmisije();
        for (Emisija e : emisije) {
            if (e.getId() == this.id) {
                setNaziv(e.getNaziv());
                setVrsta(e.getVrstaEmisije().getVrstaId());
                setTrajanje(e.getTrajanje());
                setPocetakEmisije(pocetakEmisije);
                return;
            }
        }
    }

    private void vrstaEmisijeUpdate() {
        LoadedData ld = LoadedData.getInstance();
        
        for (VrstaEmisije vEm : ld.getVrsteEmisija()) {
            if (this.vrstaEmisije != null) {
                if (vEm.getVrstaId() == this.vrstaEmisije.getVrstaId()) {
                    this.vrstaEmisije = vEm;
                    break;
                }
            }
        }
    }

    private void updateSuradnici() {
        for (OsobaSUlogom suradnik : suradnici) {
            suradnik.updateData();
        }
    }

}
