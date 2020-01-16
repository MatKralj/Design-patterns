package mkralj_zadaca_3.MVC.model;

import java.util.Map;
import mkralj_zadaca_3.MVC.UserInput;
import mkralj_zadaca_3.TVKuca;

public class ModelChoice6 extends Model {

    public ModelChoice6() {
        super.requiredData = null;
    }

    @Override
    protected ModelReturnMessage handle() {
        TVKuca tvKuca = TVKuca.getInstance();
        ModelReturnMessage returnMe = new ModelReturnMessage(tvKuca.getSavedInfo());
        return returnMe;
    }

    protected boolean initializeArguments(Map<UserInput.InputKey, String> userInputs) {
        return true;
    }
}
