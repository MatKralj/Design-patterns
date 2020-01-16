package mkralj_zadaca_3.MVC.model;

import java.util.ArrayList;
import java.util.Map;
import mkralj_zadaca_3.MVC.UserInput;
import mkralj_zadaca_3.MVC.UserInput.InputKey;
import mkralj_zadaca_3.chainOfResponsibility.Chain.SortAs;
import mkralj_zadaca_3.chainOfResponsibility.Chain.SortBy;
import mkralj_zadaca_3.chainOfResponsibility.ChainOfResponsibility;
import mkralj_zadaca_3.emisija.Emisija;

public class ModelChoice8 extends Model {

    private SortBy sortBy = null;
    private SortAs sortAs = null;

    public ModelChoice8() {
        super.requiredData = new InputKey[]{InputKey.SORTBY, InputKey.SORTAS};
    }

    @Override
    protected ModelReturnMessage handle() {
        ChainOfResponsibility chain = new ChainOfResponsibility(sortBy, sortAs);
        ArrayList<Emisija> sortedList = chain.sort();
        ModelReturnMessage returnMe = new ModelReturnMessage();

        for (Emisija em : sortedList) {
            returnMe.add(em.getId() + "-" + em.getNaziv()+"-"+em.getVrstaEmisije().getNazivVrste());
        }
        return returnMe;
    }

    protected boolean initializeArguments(Map<UserInput.InputKey, String> userInputs) {
        if (userInputs.size() != 2) {
            return false;
        }
        try {
            String sortByStr = userInputs.get(UserInput.InputKey.SORTBY);
            String sortAsStr = userInputs.get(UserInput.InputKey.SORTAS);

            if (sortByStr != null && sortAsStr != null) {
                this.sortAs = SortAs.valueOf(sortAsStr.toUpperCase());
                this.sortBy = SortBy.valueOf(sortByStr.toUpperCase());
            }

            if (this.sortAs == null || this.sortBy == null) {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
