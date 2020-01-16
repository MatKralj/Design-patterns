package mkralj_zadaca_3.MVC.model;

public class ModelFactory {

    public Model getRightModel(String userMenuChouce) {

        switch (userMenuChouce) {
            case "1":
                return new ModelChoice1();
            case "2":
                return new ModelChoice2();
            case "3":
                return new ModelChoice3();
            case "4":
                return new ModelChoice4();
            case "5":
                return new ModelChoice5();
            case "6":
                return new ModelChoice6();
            case "7":
                return new ModelChoice7();
            case "8":
                return new ModelChoice8();
            default:
                return null;
        }
    }

}
