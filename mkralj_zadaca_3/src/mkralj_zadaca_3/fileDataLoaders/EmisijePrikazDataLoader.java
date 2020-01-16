package mkralj_zadaca_3.fileDataLoaders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.regex.Pattern;
import static java.util.stream.IntStream.builder;
import mkralj_zadaca_3.osoba.OsobaSUlogom;
import mkralj_zadaca_3.TVKuca;
import mkralj_zadaca_3.emisija.EmisijaZaPrikaz;
import mkralj_zadaca_3.helpClasses.DanUTjednuHelper;
import mkralj_zadaca_3.helpClasses.DanUTjednuHelper.Dan;
import mkralj_zadaca_3.helpClasses.StringToInt;
import mkralj_zadaca_3.helpClasses.StringToLocalTime;
import mkralj_zadaca_3.rasporedComposite.DanElementComposite;
import mkralj_zadaca_3.rasporedComposite.EmisijaElement;
import mkralj_zadaca_3.rasporedComposite.RasporedComponent;

public class EmisijePrikazDataLoader extends FileDataLoader {

    private final String regexHasDays = "^\\d+\\s*;[\\d-;,:\\s]*$";
    private final RasporedComponent zadnjiDodaniProgram;

    public EmisijePrikazDataLoader(String url) {
        super(url);

        this.zadnjiDodaniProgram = TVKuca.getInstance().getLastChild();
    }

    @Override
    protected boolean doLineCheck(String line) {
        return Pattern.matches(regexHasDays, line);
    }

    @Override
    protected void addLineToSolution(String line) {
        String[] splitedString = line.split(";");
        int id = -1;
        String daniStr = "";
        LocalDateTime startTime = null;
        ArrayList<OsobaSUlogom> suradnici = null;
        try {
            id = getNumberFromString(splitedString[0].trim());
            daniStr = splitedString[1].trim();
            String vrijemeStr = splitedString[2].trim();
            startTime = getStartTime(vrijemeStr);
            String osobeUloga = splitedString[3].trim();
            suradnici = getSuradnici(osobeUloga);
        } catch (Exception ex) {

        }
        EmisijaZaPrikaz emisijaZaPrikaz = new EmisijaZaPrikaz(id, startTime, suradnici);
        dodajUComposite(emisijaZaPrikaz, daniStr);
    }

    @Override
    protected void saveSolutionData() {
        System.out.println("Emisije su ucitane u program");
    }

    private void dodajUComposite(EmisijaZaPrikaz emisijaZaPrikaz, String dani) {
        DanElementComposite dan;
        ArrayList<Dan> daniList = getDayList(dani);

        if (daniList == null || daniList.isEmpty()) {
            dan = (DanElementComposite) zadnjiDodaniProgram.findDay(Dan.NULL);
            dan.add(new EmisijaElement(emisijaZaPrikaz));
        } else {
            for (Dan d : daniList) {
                dan = (DanElementComposite) zadnjiDodaniProgram.findDay(d);
                dan.add(new EmisijaElement(emisijaZaPrikaz));
            }
        }
    }

    private int getNumberFromString(String strNum) {
        StringToInt strToInt = new StringToInt();
        return strToInt.convert(strNum);
    }

    private ArrayList<Dan> getDayList(String daniStr) {
        DanUTjednuHelper danHelper = new DanUTjednuHelper();
        return danHelper.getListOfDays(daniStr);
    }

    private LocalDateTime getStartTime(String vrijemeStr) {
        StringToLocalTime strToTime = new StringToLocalTime();
        return strToTime.convert(vrijemeStr);
    }

    private ArrayList<OsobaSUlogom> getSuradnici(String stringSuradnici) {
        ArrayList<OsobaSUlogom> suradnici = new ArrayList<>();
        try {
            String[] splitSuradnici = stringSuradnici.split(",");
            for (String suradnik : splitSuradnici) {
                String[] splitOsobaUloga = suradnik.trim().split("-");
                int osoba = getNumberFromString(splitOsobaUloga[0]);
                int uloga = getNumberFromString(splitOsobaUloga[1]);
                suradnici.add(new OsobaSUlogom(osoba, uloga));
            }
            return suradnici;
        } catch (Exception ex) {
            return suradnici;
        }
    }
}
