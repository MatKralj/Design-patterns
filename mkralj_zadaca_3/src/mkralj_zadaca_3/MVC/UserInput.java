package mkralj_zadaca_3.MVC;

import java.util.HashMap;
import java.util.Map;

public class UserInput {

    private Map<InputKey, String> inputs;
    private boolean inputNeeded = true;

    public boolean isInputNeeded() {
        return inputNeeded;
    }

    public UserInput() {
        inputs = new HashMap<>();
    }

    public UserInput(InputKey key, String input) {
        inputs = new HashMap<>();
        add(key, input);
    }

    public final boolean add(InputKey key, String input) {
        inputs.put(key, input);

        return true;
    }
    
    public void inputNotNeeded(){
        this.inputNeeded = false;
    }

    public final boolean add(String key, String input) {
        try {
            InputKey inKey = InputKey.valueOf(key.toUpperCase());
            if (inKey == null) {
                return false;
            }
            inputs.put(inKey, input);

            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Map<InputKey, String> getInputs() {
        return inputs;
    }

    public enum InputKey {
        DAN,
        IDPROGRAM,
        VRSTAEMISIJE,
        IDOSOBA,
        IDNOVEULOGE,
        IDSTAREULOGE,
        JEDNOZNACNIIDEMISIJE,
        SORTBY,
        SORTAS,
        JEDNOZNACNIIDPOHRANE
    }
}
