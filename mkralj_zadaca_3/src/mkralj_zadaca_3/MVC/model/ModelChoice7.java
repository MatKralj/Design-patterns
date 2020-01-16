package mkralj_zadaca_3.MVC.model;

import java.util.Map;
import mkralj_zadaca_3.MVC.UserInput;
import mkralj_zadaca_3.MVC.UserInput.InputKey;
import mkralj_zadaca_3.TVKuca;
import mkralj_zadaca_3.helpClasses.StringToInt;

public class ModelChoice7 extends Model {

    private int idPohranjivanja = -1;

    public ModelChoice7() {
        super.requiredData = new InputKey[]{InputKey.JEDNOZNACNIIDPOHRANE};
    }

    @Override
    protected ModelReturnMessage handle() {
        ModelReturnMessage returnMe = new ModelReturnMessage();

        TVKuca tvKuca = TVKuca.getInstance();
        String response = tvKuca.restoreFromMemento(idPohranjivanja);
        
        returnMe.add(response);
        return returnMe;
    }

    protected boolean initializeArguments(Map<UserInput.InputKey, String> userInputs) {
        if (userInputs.size() != 1) {
            return false;
        }
        try {
            StringToInt strToInt = new StringToInt();
            String idString = userInputs.get(UserInput.InputKey.JEDNOZNACNIIDPOHRANE);
            
            this.idPohranjivanja = strToInt.convert(idString);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
