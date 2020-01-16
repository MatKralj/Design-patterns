package mkralj_zadaca_3.MVC.model;

import java.util.Map;
import mkralj_zadaca_3.MVC.UserInput.InputKey;
import mkralj_zadaca_3.TVKuca;
import mkralj_zadaca_3.helpClasses.DanUTjednuHelper.Dan;
import mkralj_zadaca_3.helpClasses.StringToInt;
import mkralj_zadaca_3.tablePrinter.IRow;

public class ModelChoice1 extends Model {

    private int idPrograma = -1;
    private Dan dan;
    
    public ModelChoice1(){
        super.requiredData = new InputKey[] {InputKey.DAN, InputKey.IDPROGRAM};
    }

    @Override
    public ModelReturnMessage handle() {    
        TVKuca tvKuca = TVKuca.getInstance();
        IRow returnData = tvKuca.displayDanProgram(dan, idPrograma);
        
        return new ModelReturnMessage(returnData);
    }

    protected boolean initializeArguments(Map<InputKey, String> userInputs) {
        if (userInputs.size() != 2) {
            return false;
        }
        try {
            String danString = userInputs.get(InputKey.DAN);
            String idProgama = userInputs.get(InputKey.IDPROGRAM);
            if(danString!=null)
                this.dan = Dan.valueOf(danString.toUpperCase());
            if(idProgama!=null){
                StringToInt strToInt = new StringToInt();
                this.idPrograma = strToInt.convert(idProgama);
            }
            
            if(idPrograma<0 || (dan==null || dan.equals(Dan.NULL)))
                return false;
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
