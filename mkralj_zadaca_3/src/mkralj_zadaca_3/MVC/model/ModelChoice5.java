package mkralj_zadaca_3.MVC.model;

import java.util.Map;
import mkralj_zadaca_3.MVC.UserInput;
import mkralj_zadaca_3.MVC.UserInput.InputKey;
import mkralj_zadaca_3.TVKuca;
import mkralj_zadaca_3.helpClasses.StringToInt;

public class ModelChoice5 extends Model {

    private int jednoznacniIdEmisije = -1;

    public ModelChoice5() {
        super.requiredData = new InputKey[]{InputKey.JEDNOZNACNIIDEMISIJE};
    }

    @Override
    protected ModelReturnMessage handle() {
        TVKuca tvKuca = TVKuca.getInstance();
        boolean returnData = tvKuca.izbrisiEmisiju(jednoznacniIdEmisije);

        return new ModelReturnMessage("Emisija je izbrisana: "+returnData);
    }

    protected boolean initializeArguments(Map<UserInput.InputKey, String> userInputs) {
        if (userInputs.size() != 1) {
            return false;
        }
        try {
            String jednoznacniIdStr = userInputs.get(UserInput.InputKey.JEDNOZNACNIIDEMISIJE);
           
            if (jednoznacniIdStr != null) {
                StringToInt strToInt = new StringToInt();
                this.jednoznacniIdEmisije = strToInt.convert(jednoznacniIdStr);
            }

            if (this.jednoznacniIdEmisije < 0) {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
