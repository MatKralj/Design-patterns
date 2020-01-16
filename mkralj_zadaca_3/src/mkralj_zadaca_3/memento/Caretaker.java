package mkralj_zadaca_3.memento;

import java.util.ArrayList;

public class Caretaker {
    
    private ArrayList<Memento> savedMementos = new ArrayList<>();
    
    public void addMemento(Memento memento){
        this.savedMementos.add(memento);
    }
    
    public Memento getSavedMemento(int mementoNumber){
        try{
            for(Memento memento : savedMementos){
                if(memento.getId()==mementoNumber)
                    return memento;
            }
            return null;
        }catch(Exception ex){
            return null;
        }
    }
    
    public String getMementosInfo(){
        StringBuilder sb = new StringBuilder("Ukupni broj pohranjivanja: ");
        sb.append(savedMementos.size()).append("\n");
        for(Memento memento : savedMementos){
            sb.append(memento.toString()).append("\n");
        }
        
        return sb.toString();
    }
}
