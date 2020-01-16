package mkralj_zadaca_3.MVC.model;

import java.util.Map;
import mkralj_zadaca_3.MVC.UserInput;
import mkralj_zadaca_3.MVC.UserInput.InputKey;

public abstract class Model {

    protected InputKey[] requiredData;
    
    public ModelReturnMessage getModelResponse(UserInput input){
        Map<InputKey, String> userInputs = input.getInputs();
        if (input.isInputNeeded() && !initializeArguments(userInputs)) {
            return new ModelReturnMessage("Neispravan unos podataka.");
        }
        
        return handle();
    }
    
    protected abstract ModelReturnMessage handle();

    public InputKey[] getRequiredData(){
        return this.requiredData;
    }
    
    protected abstract boolean initializeArguments(Map<InputKey, String> userInputs);
}
