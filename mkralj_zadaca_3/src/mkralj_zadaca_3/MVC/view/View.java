package mkralj_zadaca_3.MVC.view;

import java.util.ArrayList;
import java.util.Scanner;
import mkralj_zadaca_3.MVC.UserInput;
import mkralj_zadaca_3.MVC.UserInput.InputKey;
import mkralj_zadaca_3.MVC.model.ModelReturnMessage;

public abstract class View {

    private String menu = "Main menu\n"
            + "1. Ispis podataka za program po danu\n"
            + "2. Ispis o prihodima od reklama\n"
            + "3. Ispis rasporeda prema vrsti emisija\n"
            + "4. Upravljanje osobma i ulogama\n"
            + "5. Brisanje emisije\n"
            + "6. Info o pohranjivanju\n"
            + "7. Vrati podatke pohranjivanja\n"
            + "8. Sortiraj emisije\n"
            + "9. Promijeni pogled\n"
            + "q. Izlaz\n";

    public String getMainMenu() {
        return this.menu;
    }

    public void print(ModelReturnMessage printingData) {
        ArrayList<String> mesages = printingData.getMessages();
        for (String str : mesages) {
            print(str);
        }
    }

    public UserInput getInputBy(InputKey[] requiredData) {
        UserInput returnMe = new UserInput();
        for (int i = 0; i < requiredData.length; i++) {
            print("Upisite " + getInputKeyString(requiredData[i]) + " :");
            returnMe.add(requiredData[i], getUserInput());
        }

        return returnMe;
    }

    public abstract void print(String printingData);

    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void printWrongInput() {
        print("Progresan unos");
    }

    private String getInputKeyString(InputKey inputKey) {
        switch (inputKey) {
            case DAN:
                return "ime dana (npr. ponedjeljak)";
            case IDOSOBA:
                return "id osobe";
            case IDPROGRAM:
                return "id programa";
            case IDSTAREULOGE:
                return "id stare uloge";
            case IDNOVEULOGE:
                return "id nove uloge";
            case VRSTAEMISIJE:
                return "id vrste emisije";
            case JEDNOZNACNIIDEMISIJE:
                return "jednoznacni id emisije";
            case SORTBY:
                return "sortiranje prema (ime, trajanje_em, trajanje_reklama, vrsta_emisije)";
            case SORTAS:
                return "sortiraj kao (asc, desc)";
            case JEDNOZNACNIIDPOHRANE:
                return "jednoznacni id pohrane";
            default:
                return "";
        }
    }

}
