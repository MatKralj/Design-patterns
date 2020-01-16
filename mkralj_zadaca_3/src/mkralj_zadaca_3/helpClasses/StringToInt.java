package mkralj_zadaca_3.helpClasses;

public class StringToInt {
    public StringToInt(){
    }
    
    public int convert(String stringInt){
        try{
            return Integer.parseInt(stringInt);
        }catch(Exception ex){
            return -1;
        }
    }
}
