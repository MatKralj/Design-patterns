package mkralj_zadaca_3.fileDataLoaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import mkralj_zadaca_3.helpClasses.ErrorTracker;

public abstract class FileDataLoader {

    protected File file = null;

    public FileDataLoader(String url) {
        File newFile = new File(url);
        if (!newFile.isFile() || !newFile.exists()) {
            ErrorTracker.getTracker().addErrorTrack("Datoteka s putanjom: " + url + " ne postoji.");
            return;
        }
        this.file = newFile;
    }

    private FileReader getFileReader() {
        try {
            return new FileReader(file);
        } catch (Exception ex) {
            ErrorTracker.getTracker().addErrorTrack("Datoteka: " + file.getName() + " ne postoji.");
            return null;
        }
    }

    public void loadData() {
        ArrayList<String> fileLines = readLines();
        for (String line : fileLines) {
            if (this.doLineCheck(line)) {
                addLineToSolution(line);
            } else {
                ErrorTracker.getTracker().addErrorTrack("Datoteka: " + this.file.getName()+
                        ". Linija '" + line + "' nije zapisana");
            }
        }
        saveSolutionData();
    }

    protected ArrayList<String> readLines() {
        ArrayList<String> retunArrays = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(getFileReader())) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                retunArrays.add(line.trim());
            }
        } catch (Exception ex) {
            System.out.println("Pogreska kod citanja datoteke.");
        }

        return retunArrays;
    }

    protected abstract boolean doLineCheck(String line);

    protected abstract void addLineToSolution(String line);

    protected abstract void saveSolutionData();
}
