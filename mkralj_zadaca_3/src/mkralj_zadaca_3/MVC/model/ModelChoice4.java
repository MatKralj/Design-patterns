package mkralj_zadaca_3.MVC.model;

import java.util.Map;
import mkralj_zadaca_3.LoadedData;
import mkralj_zadaca_3.MVC.UserInput;
import mkralj_zadaca_3.MVC.UserInput.InputKey;
import mkralj_zadaca_3.TVKuca;
import mkralj_zadaca_3.helpClasses.StringToInt;
import mkralj_zadaca_3.osoba.Osoba;
import mkralj_zadaca_3.osoba.Uloga;

public class ModelChoice4 extends Model {

    private int idOsobe = -1;
    private int idStareUloge = -1;
    private int idNoveUloge = -1;
    private Osoba osoba;
    private Uloga novaUloga;
    private Uloga staraUloga;

    public ModelChoice4() {
        super.requiredData = new InputKey[]{InputKey.IDOSOBA, InputKey.IDSTAREULOGE, InputKey.IDNOVEULOGE};
    }

    @Override
    protected ModelReturnMessage handle() {
        TVKuca tvKuca = TVKuca.getInstance();
        boolean returnData = tvKuca.promijeniUlogu(osoba, staraUloga, novaUloga);

        return new ModelReturnMessage("Promijena je uspjesna: " + returnData);
    }

    protected boolean initializeArguments(Map<InputKey, String> userInputs) {
        if (userInputs.size() != 3) {
            return false;
        }
        try {
            String idOsobeStr = userInputs.get(UserInput.InputKey.IDOSOBA);
            String idStareUlogeStr = userInputs.get(UserInput.InputKey.IDSTAREULOGE);
            String idNoveUlogeStr = userInputs.get(UserInput.InputKey.IDNOVEULOGE);
            if (idOsobeStr != null && idStareUlogeStr != null && idNoveUlogeStr != null) {
                StringToInt strToInt = new StringToInt();
                this.idOsobe = strToInt.convert(idOsobeStr);
                this.idNoveUloge = strToInt.convert(idNoveUlogeStr);
                this.idStareUloge = strToInt.convert(idStareUlogeStr);
            }

            if (this.idNoveUloge < 0 || this.idOsobe < 0 || this.idStareUloge < 0) {
                return false;
            }
            return initializeChangeData();
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean initializeChangeData() {
        LoadedData loadedData = LoadedData.getInstance();
        boolean osobaFound = false;
        for (Osoba o : loadedData.getOsobe()) {
            if (o.getId() == idOsobe) {
                this.osoba = o;
                osobaFound = true;
                break;
            }
        }
        boolean staraUlogaFound = false;
        boolean novaUlogaFound = false;
        for (Uloga u : loadedData.getUloge()) {
            if (!novaUlogaFound && u.getId() == idNoveUloge) {
                this.novaUloga = u;
                novaUlogaFound = true;
            } else if (!staraUlogaFound && u.getId() == idStareUloge) {
                this.staraUloga = u;
                staraUlogaFound = true;
            }
            if (staraUlogaFound && novaUlogaFound) {
                break;
            }
        }
        return osobaFound && staraUlogaFound && novaUlogaFound;
    }

}
