package mkralj_zadaca_3.emisija.vrstaEmisije;

import mkralj_zadaca_3.IData;
import mkralj_zadaca_3.LoadedData;
import mkralj_zadaca_3.helpClasses.ErrorTracker;

public class VrstaEmisije implements IData {

    private int vrstaId;
    private String nazivVrste;
    private boolean imaReklame;
    private int maxTrajanjeReklama;

    public VrstaEmisije(int vrstaId) {
        this.vrstaId = vrstaId;
    }

    public VrstaEmisije() {
    }

    public void setNazivVrste(String nazivVrste) {
        this.nazivVrste = nazivVrste;
    }

    public void setImaReklame(boolean imaReklame) {
        this.imaReklame = imaReklame;
    }

    public void setMaxTrajanjeReklama(int maxTrajanjeReklama) {
        if (this.imaReklame) {
            this.maxTrajanjeReklama = maxTrajanjeReklama;
        }else{
            this.maxTrajanjeReklama = 0;
        }
    }

    public String getNazivVrste() {
        return nazivVrste;
    }

    public boolean isImaReklame() {
        return imaReklame;
    }

    public int getMaxTrajanjeReklama() {
        return maxTrajanjeReklama;
    }

    public int getVrstaId() {
        return this.vrstaId;
    }

    @Override
    public boolean updateData() {
        LoadedData ld = LoadedData.getInstance();

        for (VrstaEmisije vEmisije : ld.getVrsteEmisija()) {
            if (vEmisije.getVrstaId() == this.vrstaId) {
                this.setImaReklame(vEmisije.isImaReklame());
                this.setMaxTrajanjeReklama(vEmisije.getMaxTrajanjeReklama());
                this.setNazivVrste(vEmisije.getNazivVrste());
                return true;
            }
        }
        ErrorTracker.getTracker().addErrorTrack("Vrsta emisije koja ima id: " + this.vrstaId + " ne postoji.");
        return false;
    }

    public void setIdVrsteEmisije(int id) {
        this.vrstaId = id;
    }

    @Override
    public String toString() {
        return this.nazivVrste + " " + this.imaReklame + " " + this.maxTrajanjeReklama;
    }
}
