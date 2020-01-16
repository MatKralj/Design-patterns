package mkralj_zadaca_3.fileDataLoaders;

import java.util.ArrayList;
import java.util.regex.Pattern;
import mkralj_zadaca_3.LoadedData;
import mkralj_zadaca_3.osoba.Uloga;
import mkralj_zadaca_3.helpClasses.StringToInt;

public class UlogeDataLoader extends FileDataLoader {

    private final String regexPattern = "^\\d+;\\s*[\\w\\d\\s]+$";
    private ArrayList<Uloga> listaUloga = null;

    public UlogeDataLoader(String url) {
        super(url);
        listaUloga = new ArrayList<>();
    }

    @Override
    protected boolean doLineCheck(String line) {
        return Pattern.matches(regexPattern, line);
    }

    @Override
    protected void addLineToSolution(String line) {
        String[] splitLine = line.split(";");
        int id = getLineId(splitLine[0].trim());
        String opis = splitLine[1].trim();

        listaUloga.add(new Uloga(id, opis));
    }

    private int getLineId(String stringId) {
        StringToInt strToint = new StringToInt();

        return strToint.convert(stringId);
    }

    @Override
    protected void saveSolutionData() {
        LoadedData.getInstance().setUloge(this.listaUloga);
    }

}
