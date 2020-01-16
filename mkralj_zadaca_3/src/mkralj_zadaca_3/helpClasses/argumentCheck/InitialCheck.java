package mkralj_zadaca_3.helpClasses.argumentCheck;

import mkralj_zadaca_3.helpClasses.ErrorTracker;

public class InitialCheck implements ICheck{

    private final String[] args;
    private final int numOfArgs;
    
    public InitialCheck(String[] args, int numOfArgs){
        this.args = args;
        this.numOfArgs = numOfArgs;
    }

    @Override
    public boolean check() {
        ErrorTracker tracker = ErrorTracker.getTracker();
        if (args.length != numOfArgs) {
            tracker.addErrorTrack("Trebalo bi biti tocno 8 argumenata. 4 opcije i 4 imena datoteka.");
            return false;
        }

        for (int i = 0; i < args.length; i += 2) {
            if (args[i].length() != 2) {
                tracker.addErrorTrack("Svaki drugi argument treba imati tocno 2 znaka. Odnosno treba biti opcija.");
                return false;
            }
        }

        return true;
    }

    @Override
    public String nameOfCheck() {
        return "Initial check";
    }
    
}
