package mkralj_zadaca_3.emisija;

import java.time.LocalDateTime;
import java.util.ArrayList;
import mkralj_zadaca_3.ICloneable;
import mkralj_zadaca_3.IData;
import mkralj_zadaca_3.LoadedData;
import mkralj_zadaca_3.osoba.Osoba;
import mkralj_zadaca_3.osoba.OsobaSUlogom;
import mkralj_zadaca_3.osoba.Uloga;
import mkralj_zadaca_3.visitor.Visitable;
import mkralj_zadaca_3.visitor.Visitor;

public class EmisijaZaPrikaz implements IData, Comparable<EmisijaZaPrikaz>, Observer, Visitable, ICloneable<EmisijaZaPrikaz> {

    private Emisija emisija;
    private int idEmisija;
    private LocalDateTime pocetakEmisije;
    private LocalDateTime zavrsetakEmisije;
    private int redniBroj = -1;

    public int getRedniBroj() {
        return redniBroj;
    }

    private volatile ArrayList<OsobaSUlogom> sviSuradnici;

    public EmisijaZaPrikaz(int idEmisija, LocalDateTime pocetakPrikazivanja, ArrayList<OsobaSUlogom> suradnici) {
        setIdEmisija(idEmisija);
        setPocetakEmisije(pocetakPrikazivanja);
        setSuradnici(suradnici);
    }

    private EmisijaZaPrikaz(EmisijaZaPrikaz target) {
        if (target != null) {
            this.sviSuradnici = new ArrayList<>();
            this.emisija = target.emisija;
            this.idEmisija = target.idEmisija;
            this.pocetakEmisije = target.pocetakEmisije;
            for(OsobaSUlogom oSU : target.sviSuradnici){
                this.sviSuradnici.add(oSU.clone());
            }
            this.zavrsetakEmisije = target.zavrsetakEmisije;
            this.redniBroj = target.redniBroj;
        }
    }

    public Emisija getEmisija() {
        return emisija;
    }

    public LocalDateTime getZavrsetakEmisije() {
        return zavrsetakEmisije;
    }

    public void setEmisija(Emisija emisija) {
        this.emisija = emisija;
    }

    public int getIdEmisija() {
        return idEmisija;
    }

    public final void setIdEmisija(int idEmisija) {
        this.idEmisija = idEmisija;
    }

    public LocalDateTime getPocetakEmisije() {
        return pocetakEmisije;
    }

    public final void setPocetakEmisije(LocalDateTime pocetakEmisije) {
        this.pocetakEmisije = pocetakEmisije;
        if (this.emisija != null && pocetakEmisije != null) {
            this.zavrsetakEmisije = pocetakEmisije.plusMinutes(this.emisija.getTrajanje());
        } else {
            this.zavrsetakEmisije = null;
        }
    }

    public ArrayList<OsobaSUlogom> getSuradnici() {
        return sviSuradnici;
    }

    public final void setSuradnici(ArrayList<OsobaSUlogom> suradnici) {
        this.sviSuradnici = suradnici;
    }

    @Override
    public boolean updateData() {
        boolean emisijaPostoji = updateEmisije();
        if(sviSuradnici == null) {
            sviSuradnici = new ArrayList<>();
        }
        if (emisijaPostoji) {
            addSuradniciFromEmisija();
        }

        updateSuradnici();
        subscribe();

        return emisijaPostoji;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getEmisija().toString())
                .append('[').append(getPocetakEmisije())
                .append('-').append(getZavrsetakEmisije()).append(']')
                .append(" Prioritet: ");
        return sb.toString();
    }

    private boolean updateEmisije() {
        ArrayList<Emisija> emisije = LoadedData.getInstance().getEmisije();
        for (Emisija e : emisije) {
            if (e.getId() == this.idEmisija) {
                this.emisija = e;
                this.emisija.updateData();
                postaviZavrsetakEmisije();
                return true;
            }
        }
        return false;
    }

    private void updateSuradnici() {
        for (OsobaSUlogom suradnik : sviSuradnici) {
            suradnik.updateData();
        }
    }

    private void postaviZavrsetakEmisije() {
        if (pocetakEmisije != null) {
            this.zavrsetakEmisije = pocetakEmisije;
            zavrsetakEmisije = zavrsetakEmisije.plusMinutes(this.emisija.getTrajanje());
        }
    }

    @Override
    public int compareTo(EmisijaZaPrikaz o) {
        LocalDateTime pocetak1 = this.getPocetakEmisije();
        LocalDateTime pocetak2 = o.getPocetakEmisije();
        if (pocetak1 == null || pocetak2 == null) {
            return -1;
        }

        return pocetak1.compareTo(pocetak2);
    }

    @Override
    public boolean update(Osoba osoba, Uloga staraUloga, Uloga novaUloga) {
        try {
            for (OsobaSUlogom suradnik : this.sviSuradnici) {
                if (osoba.getId() == suradnik.getOsoba().getId()) {
                    if (suradnik.getUloga().getId() == staraUloga.getId()) {
                        suradnik.updateUloga(novaUloga);
                        return true;
                    }
                }
            }
        } catch (Exception ex) {
        }

        return false;
    }

    @Override
    public void subscribe() {
        if (sviSuradnici == null) {
            return;
        }
        for (OsobaSUlogom suradnik : sviSuradnici) {
            suradnik.registerObserver(this);
        }
    }

    @Override
    public void unSubscribe() {
        if (sviSuradnici == null) {
            return;
        }
        for (OsobaSUlogom suradnik : sviSuradnici) {
            suradnik.removeObserver(this);
        }
    }

    private void addSuradniciFromEmisija() {
        ArrayList<OsobaSUlogom> suradniciEmisije = emisija.getSuradnici();
        if (suradniciEmisije != null && !suradniciEmisije.isEmpty()) {
            this.sviSuradnici.addAll(suradniciEmisije);
        }
    }

    public void setRedniBroj(int nextRedniBroj) {
        this.redniBroj = nextRedniBroj;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public EmisijaZaPrikaz clone() {
        return new EmisijaZaPrikaz(this);
    }

}
