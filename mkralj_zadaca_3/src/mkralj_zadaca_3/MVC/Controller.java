package mkralj_zadaca_3.MVC;

import mkralj_zadaca_3.MVC.UserInput.InputKey;
import mkralj_zadaca_3.MVC.model.Model;
import mkralj_zadaca_3.MVC.model.ModelFactory;
import mkralj_zadaca_3.MVC.model.ModelReturnMessage;
import mkralj_zadaca_3.MVC.view.View;
import mkralj_zadaca_3.MVC.view.View1;
import mkralj_zadaca_3.MVC.view.View2;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public Controller() {
        this.model = null;
        this.view = new View1();
    }

    public void start() {
        ModelFactory modelFactory = new ModelFactory();
        while (true) {
            view.print(view.getMainMenu());
            view.print("Unesite opciju: ");
            String userInput = view.getUserInput();
            if (userInput.equals("q")) {
                return;
            }
            if (userInput.equals("9")) {
                changeView();
            } else {
                handleTheInput(modelFactory, userInput);
            }
        }
    }

    private void handleTheInput(ModelFactory modelFactory, String userInput) {
        if ((model = modelFactory.getRightModel(userInput)) != null) {
            InputKey[] requiredData = model.getRequiredData();
            UserInput input = new UserInput();
            if (requiredData != null) {
                input = view.getInputBy(requiredData);
            }else
                input.inputNotNeeded();
            
            ModelReturnMessage response = model.getModelResponse(input);
            view.print(response);
        } else {
            view.printWrongInput();
        }
    }

    private void changeView() {
        if (this.view instanceof View1) {
            this.view = new View2();
        } else {
            this.view = new View1();
        }
    }
}
