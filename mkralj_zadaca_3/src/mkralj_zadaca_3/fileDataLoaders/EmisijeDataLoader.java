package mkralj_zadaca_3.fileDataLoaders;

import java.util.ArrayList;
import java.util.regex.Pattern;
import mkralj_zadaca_3.LoadedData;
import mkralj_zadaca_3.osoba.OsobaSUlogom;
import mkralj_zadaca_3.emisija.Emisija;
import mkralj_zadaca_3.emisija.EmisijaBuilder;
import mkralj_zadaca_3.emisija.EmisijaBuilderImpl;
import mkralj_zadaca_3.helpClasses.ErrorTracker;
import mkralj_zadaca_3.helpClasses.StringToInt;

public class EmisijeDataLoader extends FileDataLoader {

    private final String regexPattern = "^\\d+\\s*;\\s*[^;]+;\\s*\\d+\\s*;\\s*\\d+\\s*;(,*\\s*\\d+\\s*-\\s*\\d+\\s*)*$";
    private ArrayList<Emisija> emisije = null;

    public EmisijeDataLoader(String url) {
        super(url);
        this.emisije = new ArrayList<>();
    }

    @Override
    protected boolean doLineCheck(String line) {
        int length = line.split(";").length;
        return Pattern.matches(regexPattern, line) && length >= 4 && length <= 5;
    }

    @Override
    protected void addLineToSolution(String line) {
        String[] splitedLine = line.split(";");
        int splitLength = splitedLine.length;
        EmisijaBuilder emisijaBuilder = null;
        switch (splitLength) {
            case 4:
                emisijaBuilder = loadFourArguments(splitedLine);
                break;
            case 5:
                emisijaBuilder = loadFiveArguments(splitedLine);
                break;
        }
        if (emisijaBuilder != null) {
            this.emisije.add(emisijaBuilder.build());
        }
    }

    @Override
    protected void saveSolutionData() {
        LoadedData.getInstance().setEmisije(emisije);
    }

    private EmisijaBuilder loadFourArguments(String[] splitedLine) {
        int id = getNumberFromString(splitedLine[0].trim());
        String nazivEmisije = splitedLine[1].trim();
        int vrsta = getNumberFromString(splitedLine[2].trim());
        int trajanjemin = getNumberFromString(splitedLine[3].trim());
        if(trajanjemin<=0){
            ErrorTracker.getTracker().addErrorTrack("Emisija "+nazivEmisije+" nije dodana zbog neispravnog trajanja.");
            return null;
        }
        EmisijaBuilder builder = new EmisijaBuilderImpl();
        return builder.setId(id).setNaziv(nazivEmisije).setTrajanje(trajanjemin).setVrsta(vrsta);
    }

    private EmisijaBuilder loadFiveArguments(String[] splitedLine) {
        EmisijaBuilder builder = loadFourArguments(splitedLine);
        if(builder==null)
            return null;
        ArrayList<OsobaSUlogom> suradnici = getSuradnici(splitedLine[4].trim()
        );
        return builder.setSuradnici(suradnici);
    }

    private int getNumberFromString(String strNum) {
        StringToInt strToInt = new StringToInt();
        return strToInt.convert(strNum);
    }

    private ArrayList<OsobaSUlogom> getSuradnici(String stringSuradnici) {
        ArrayList<OsobaSUlogom> suradnici = new ArrayList<>();
        try{
            String[] splitSuradnici = stringSuradnici.split(",");
            for (String suradnik : splitSuradnici) {
                String[] splitOsobaUloga = suradnik.trim().split("-");
                int osoba = getNumberFromString(splitOsobaUloga[0]);
                int uloga = getNumberFromString(splitOsobaUloga[1]);
                suradnici.add(new OsobaSUlogom(osoba, uloga));
            }
            return suradnici;
        }catch(Exception ex){
            return suradnici;
        }
    }

}
