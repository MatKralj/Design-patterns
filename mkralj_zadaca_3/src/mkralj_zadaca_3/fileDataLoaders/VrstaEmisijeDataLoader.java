package mkralj_zadaca_3.fileDataLoaders;

import mkralj_zadaca_3.emisija.vrstaEmisije.VrstaEmisijeBuilder;
import mkralj_zadaca_3.emisija.vrstaEmisije.VrstaEmisijeBuilderImpl;
import java.util.ArrayList;
import java.util.regex.Pattern;
import mkralj_zadaca_3.LoadedData;
import mkralj_zadaca_3.emisija.vrstaEmisije.VrstaEmisije;
import mkralj_zadaca_3.helpClasses.StringToInt;

public class VrstaEmisijeDataLoader extends FileDataLoader {

    private final String regexPattern = "^\\d+\\s*;\\s*[^;]+;\\s*[01]{1}\\s*;\\s*\\d+\\s*$";
    private ArrayList<VrstaEmisije> vrsteEmisija = null;

    public VrstaEmisijeDataLoader(String url) {
        super(url);
        vrsteEmisija = new ArrayList<>();
    }

    @Override
    protected boolean doLineCheck(String line) {
        return Pattern.matches(regexPattern, line);
    }

    @Override
    protected void addLineToSolution(String line) {
        String[] splitedLine = line.split(";");

        VrstaEmisijeBuilder builder = createBuilder(splitedLine);
        
        this.vrsteEmisija.add(builder.build());
    }

    @Override
    protected void saveSolutionData() {
        LoadedData.getInstance().setVrsteEmisija(this.vrsteEmisija);
    }

    private VrstaEmisijeBuilder createBuilder(String[] splitedLine) {
        VrstaEmisijeBuilder returnMe = new VrstaEmisijeBuilderImpl();

        StringToInt strToInt = new StringToInt();
        int id = strToInt.convert(splitedLine[0].trim());
        String naziv = splitedLine[1].trim();
        int imaReklama = strToInt.convert(splitedLine[2].trim());
        int maxTrajanjeReklama = strToInt.convert(splitedLine[3].trim());
        
        returnMe.setIdVrste(id).setReklameOpcije(imaReklama, maxTrajanjeReklama).setNazivVrste(naziv);
        return returnMe;
    }

}
