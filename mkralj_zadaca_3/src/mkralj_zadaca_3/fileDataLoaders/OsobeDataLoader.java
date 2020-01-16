package mkralj_zadaca_3.fileDataLoaders;

import java.util.ArrayList;
import java.util.regex.Pattern;
import mkralj_zadaca_3.LoadedData;
import mkralj_zadaca_3.osoba.Osoba;
import mkralj_zadaca_3.helpClasses.StringToInt;

public class OsobeDataLoader extends FileDataLoader {

    private final String regexPattern = "^\\d+\\s*;\\s*[^;]+$";
    private ArrayList<Osoba> osobe;
    
    public OsobeDataLoader(String url) {
        super(url);
        osobe = new ArrayList<>();
    }

    @Override
    protected boolean doLineCheck(String line) {
        return Pattern.matches(regexPattern, line);
    }

    @Override
    protected void addLineToSolution(String line) {
        String[] splitedLine = line.trim().split(";");
        int id = getId(splitedLine[0].trim());
        String imePrezime = splitedLine[1].trim();
        
        Osoba novaOsoba = new Osoba(imePrezime, id);
        this.osobe.add(novaOsoba);
    }

    @Override
    protected void saveSolutionData() {
        LoadedData.getInstance().setOsobe(osobe);
    }

    private int getId(String trim) {
        StringToInt strToInt = new StringToInt();
        return strToInt.convert(trim);
    }
}
