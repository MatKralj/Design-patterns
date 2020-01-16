package mkralj_zadaca_3.helpClasses.argumentCheck;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import mkralj_zadaca_3.helpClasses.ErrorTracker;

public class HardCheck implements ICheck {

    private final String[] args;
    private final String posibleOptionsString;
    private LinkedList<String> possibleOptions;

    public HardCheck(String[] args, String[] possibleOptions) {
        this.args = args;
        this.possibleOptions = new LinkedList<>(Arrays.asList(possibleOptions));
        posibleOptionsString = this.possibleOptions.toString();
    }

    @Override
    public boolean check() {
        for (int i = 0; i < args.length; i++) {
            boolean argOptionFound = false;
            for (int j = 0; j < possibleOptions.size(); j++) {
                if (args[i].equalsIgnoreCase(possibleOptions.get(j))) {
                    possibleOptions.remove(j);
                    if (!testUrl(args, i)) {
                        return false;
                    }
                    argOptionFound = true;
                    i++;
                    break;
                }
            }
            if (!argOptionFound) {
                ErrorTracker.getTracker().addErrorTrack("Opcije argumenata trebaju biti " + posibleOptionsString + ". "
                        + "Bez ponavljanja vec iskoristene opcije.");
                return false;
            }
        }
        return true;
    }

    @Override
    public String nameOfCheck() {
        return "Hard check";
    }

    private boolean testUrl(String[] args, int i) {
        String fileUrl = args[i + 1];

        if (!checkUrlIsReadable(fileUrl)) {
            return false;
        }
        return true;
    }

    private boolean checkUrlIsReadable(String txtFileUrl) {
        try ( FileReader fileReader = new FileReader(new File(txtFileUrl))) {
            fileReader.read();
        } catch (Exception e) {
            ErrorTracker.getTracker().addErrorTrack("Datoteka: " + txtFileUrl + " ne postoji ili ne može biti procitana.");
            return false;
        }

        return true;
    }

}
