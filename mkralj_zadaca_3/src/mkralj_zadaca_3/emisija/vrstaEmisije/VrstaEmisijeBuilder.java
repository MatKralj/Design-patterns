package mkralj_zadaca_3.emisija.vrstaEmisije;

public interface VrstaEmisijeBuilder {

    public VrstaEmisije build();

    public VrstaEmisijeBuilder setIdVrste(int id);

    public VrstaEmisijeBuilder setNazivVrste(String nazivVrste);

    public VrstaEmisijeBuilder setReklameOpcije(int imaReklama, int maxTrajanje);
}
