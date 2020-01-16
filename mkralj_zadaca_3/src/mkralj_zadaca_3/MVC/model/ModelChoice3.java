package mkralj_zadaca_3.MVC.model;

import java.util.Map;
import mkralj_zadaca_3.MVC.UserInput;
import mkralj_zadaca_3.TVKuca;
import mkralj_zadaca_3.helpClasses.StringToInt;
import mkralj_zadaca_3.tablePrinter.IRow;

public class ModelChoice3 extends Model{
    
    private int vrstaEmisije = -1;
    
    public ModelChoice3(){
        super.requiredData = new UserInput.InputKey[] {UserInput.InputKey.VRSTAEMISIJE};
    }

    @Override
    protected ModelReturnMessage handle() {
        TVKuca tvKuca = TVKuca.getInstance();
        IRow returnData = tvKuca.displayVrstaEmisije(vrstaEmisije);

        return new ModelReturnMessage(returnData);
    }
    
    protected boolean initializeArguments(Map<UserInput.InputKey, String> userInputs) {
        if (userInputs.size() != 1) {
            return false;
        }
        try {
            String idEmisije = userInputs.get(UserInput.InputKey.VRSTAEMISIJE);
            if (idEmisije != null) {
                StringToInt strToInt = new StringToInt();
                this.vrstaEmisije = strToInt.convert(idEmisije);
            }

            if (vrstaEmisije < 0) {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
