package mkralj_zadaca_3.emisija.vrstaEmisije;

public class VrstaEmisijeBuilderImpl implements VrstaEmisijeBuilder {
    
    VrstaEmisije vrstaEmisije = null;

    public VrstaEmisijeBuilderImpl() {
        vrstaEmisije = new VrstaEmisije();
    }

    @Override
    public VrstaEmisije build() {
        return this.vrstaEmisije;
    }

    @Override
    public VrstaEmisijeBuilder setIdVrste(int id) {
        this.vrstaEmisije.setIdVrsteEmisije(id);
        
        return this;
    }

    @Override
    public VrstaEmisijeBuilder setNazivVrste(String nazivVrste) {
        this.vrstaEmisije.setNazivVrste(nazivVrste);
        
        return this;
    }

    @Override
    public VrstaEmisijeBuilder setReklameOpcije(int imaReklama, int maxTrajanje) {
        this.vrstaEmisije.setImaReklame((imaReklama != 0));
        
        if(this.vrstaEmisije.isImaReklame())
            this.vrstaEmisije.setMaxTrajanjeReklama(maxTrajanje);
        else
            this.vrstaEmisije.setMaxTrajanjeReklama(0);
        
        return this;
    }
    
}
