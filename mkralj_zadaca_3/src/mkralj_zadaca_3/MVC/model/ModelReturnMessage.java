package mkralj_zadaca_3.MVC.model;

import java.util.ArrayList;
import mkralj_zadaca_3.tablePrinter.IRow;

public class ModelReturnMessage {
    
    private ArrayList<String> messages;
    
    public ModelReturnMessage(){
        messages = new ArrayList<>();
    }
    
    public ModelReturnMessage(String message){
        messages = new ArrayList<>();
        add(message);
    }
    
    public ModelReturnMessage(IRow row){
        messages = new ArrayList<>();
        ArrayList<String[]> rows = row.getRows();
        for(String[] rowString : rows){
            String column0 = rowString[0];
            String column1 = rowString[1];
            String column2 = rowString[2];
            add(String.format("%s%s%s\n",column0,column1,column2));
        }
    }
    
    public final void add(String message){
        this.messages.add(message);
    }
    
    public ArrayList<String> getMessages(){
        return messages;
    }
}
