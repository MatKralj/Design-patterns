package mkralj_zadaca_3;

import java.util.Map.Entry;
import java.util.Set;
import mkralj_zadaca_3.MVC.Controller;
import mkralj_zadaca_3.fileDataLoaders.FileDataLoader;
import mkralj_zadaca_3.fileDataLoaders.FileDataLoaderFactory;
import mkralj_zadaca_3.helpClasses.ShutdownHandler;
import mkralj_zadaca_3.helpClasses.argumentCheck.ArgsChecker;

public class UpravljanjeProgramimaTvKuce {

    public static void main(String[] args) {
        UpravljanjeProgramimaTvKuce upravljanjeProg = new UpravljanjeProgramimaTvKuce();
        upravljanjeProg.addShutdownHook();

        ArgsChecker argsChecker = new ArgsChecker(args);
        upravljanjeProg.checkArguments(argsChecker);
        upravljanjeProg.loadData(argsChecker.getKeyValueOptions().entrySet());

        TVKuca tvKuca = TVKuca.getInstance();
        upravljanjeProg.updateData();
        
        tvKuca.rasporedi();

        Controller controler = new Controller();
        controler.start();
    }
    
    private void addShutdownHook() {
        ShutdownHandler sHandler = new ShutdownHandler();
        sHandler.addShutdownHook();
    }

    private void checkArguments(ArgsChecker argsChecker) {
        if (!argsChecker.checkArgs()) {
            System.exit(1);
        }
    }

    private void loadData(Set<Entry<String, String>> argumentsAndUrls) {
        FileDataLoaderFactory dataLoaderFactory = new FileDataLoaderFactory();

        for (Entry<String, String> keyValue : argumentsAndUrls) {
            String option = keyValue.getKey();
            String url = keyValue.getValue();
            FileDataLoader dataLoader = dataLoaderFactory.getTheRightLoader(option, url);

            dataLoader.loadData();
        }
    }

    private void updateData() {
        LoadedData.getInstance().updateData();
        TVKuca.getInstance().updateData();
    }

}
