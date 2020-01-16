package mkralj_zadaca_3.MVC.model;

import java.util.Map;
import mkralj_zadaca_3.MVC.UserInput;
import mkralj_zadaca_3.MVC.UserInput.InputKey;
import mkralj_zadaca_3.TVKuca;
import mkralj_zadaca_3.helpClasses.DanUTjednuHelper;
import mkralj_zadaca_3.helpClasses.StringToInt;

public class ModelChoice2 extends Model {

    private int idPrograma = -1;
    private DanUTjednuHelper.Dan dan;
    
    public ModelChoice2(){
        super.requiredData = new InputKey[] {InputKey.DAN, InputKey.IDPROGRAM};
    }

    @Override
    protected ModelReturnMessage handle() {
        TVKuca tvKuca = TVKuca.getInstance();
        int returnData = tvKuca.displayPrihodReklama(dan, idPrograma);

        return new ModelReturnMessage("Prihod od reklama: " + returnData);
    }

    protected boolean initializeArguments(Map<UserInput.InputKey, String> userInputs) {
        if (userInputs.size() != 2) {
            return false;
        }
        try {
            String danString = userInputs.get(UserInput.InputKey.DAN);
            String idProgama = userInputs.get(UserInput.InputKey.IDPROGRAM);
            if (danString != null) {
                this.dan = DanUTjednuHelper.Dan.valueOf(danString.toUpperCase());
            }
            if (idProgama != null) {
                StringToInt strToInt = new StringToInt();
                this.idPrograma = strToInt.convert(idProgama);
            }

            if (idPrograma < 0 || (dan == null || dan.equals(DanUTjednuHelper.Dan.NULL))) {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
