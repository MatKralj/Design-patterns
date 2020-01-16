package mkralj_zadaca_3.fileDataLoaders;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.regex.Pattern;
import mkralj_zadaca_3.LoadedData;
import mkralj_zadaca_3.TVKuca;
import mkralj_zadaca_3.helpClasses.StringToInt;
import mkralj_zadaca_3.helpClasses.StringToLocalTime;
import mkralj_zadaca_3.program.Program;
import mkralj_zadaca_3.program.ProgramBuilderImpl;
import mkralj_zadaca_3.rasporedComposite.ProgramComposite;
import mkralj_zadaca_3.program.ProgramBuilder;

public class ProgramiDataLoader extends FileDataLoader {

    private final String regexPattern = "^\\d+\\s*;[^;]+;([\\s\\d]+:[\\s\\d]+)*;([\\s\\d]+:[\\s\\d]+)*;(.[^.]*\\.(txt))$";
    private ArrayList<Program> programi = null;

    public ProgramiDataLoader(String url) {
        super(url);
        this.programi = new ArrayList<>();
    }

    @Override
    protected boolean doLineCheck(String line) {
        return Pattern.matches(regexPattern, line);
    }

    @Override
    protected void addLineToSolution(String line) {
        String[] splitLine = line.split(";");
        for (int i = 0; i < splitLine.length; i++) {
            splitLine[i] = splitLine[i].trim();
        }

        Program program = createProgram(splitLine);

        ProgramComposite newProgramComp = new ProgramComposite(program);
        TVKuca.getInstance().add(newProgramComp);
        
        dodajEmisije(program.getNazivDatoteke());
    }

    private Program createProgram(String[] splitLine) {
        ProgramBuilder pBuilder = new ProgramBuilderImpl();
        int id = getId(splitLine[0].trim());
        String progName = splitLine[1].trim();
        LocalDateTime startTime = getTime(splitLine[2].trim());
        LocalDateTime progEnd = getEndOfProgram(splitLine[3].trim());
        String fileName = splitLine[4].trim();

        pBuilder.setProgramId(id).setProgramName(progName)
                .setProgramStartTime(startTime).setProgramEndTime(progEnd)
                .setProgramFileName(fileName);
        return pBuilder.build();
    }

    private int getId(String trim) {
        StringToInt strToInt = new StringToInt();
        return strToInt.convert(trim);
    }

    private LocalDateTime getTime(String trim) {
        StringToLocalTime strToTime = new StringToLocalTime();
        return strToTime.convert(trim);
    }

    @Override
    protected void saveSolutionData() {
        System.out.println("Program spremljen u composite.");
    }

    private LocalDateTime getEndOfProgram(String timeString) {
        LocalDateTime returnMe = getTime(timeString);
        if (returnMe == null) {
            returnMe = LocalDateTime.of(2000, 1, 23, 59, 59);
        }

        return returnMe;
    }

    private void dodajEmisije(String nazivDatoteke) {
        String tvKucaPath = this.file.getPath();
        String programFilePath = tvKucaPath.replace(this.file.getName(), nazivDatoteke);

        EmisijePrikazDataLoader emisijePrikazaLoader = new EmisijePrikazDataLoader(programFilePath);
        emisijePrikazaLoader.loadData();
    }
}
