package mkralj_zadaca_3.memento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import mkralj_zadaca_3.rasporedComposite.RasporedComponent;

public class Memento {
    
    private ArrayList<RasporedComponent> savedComponents;
    private final int id;
    private String vrijemeSpremanja;
    
    public Memento(ArrayList<RasporedComponent> componentsToSave, int id){
        this.savedComponents = new ArrayList<>(componentsToSave);
        this.id = id;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.vrijemeSpremanja = LocalDateTime.now().format(formatter);
    }
    
    public ArrayList<RasporedComponent> getSavedComponents(){
        return this.savedComponents;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id: " + id + ", vrijemeSpremanja: " + vrijemeSpremanja;
    }
    
    

}
