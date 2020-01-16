package mkralj_zadaca_3.helpClasses.argumentCheck;

import java.util.HashMap;
import java.util.Map;

public class ArgsChecker {
    
    private Map<String, String> keyValueOptions;
    private final String[] args;
    private final String[] possibleOptions;

    public Map<String, String> getKeyValueOptions() {
        return keyValueOptions;
    }

    public ArgsChecker(String[] args) {
        keyValueOptions = new HashMap<>();
        this.args = args;
        this.possibleOptions = new String[]{"-u", "-t", "-e", "-o", "-v"};
    }

    public boolean checkArgs() {
        ICheck check = new InitialCheck(args, 10);
        if(!check.check())
            return false;
        check = new HardCheck(args, possibleOptions);
        if(!check.check())
            return false;

        manageArgsData();
        return true;
    }

    private void manageArgsData() {
        for(int i = 0; i<args.length;i++){
            String option = args[i];
            String fileUrl = args[++i];
            this.keyValueOptions.put(option, fileUrl);
        }
    }
       
}
