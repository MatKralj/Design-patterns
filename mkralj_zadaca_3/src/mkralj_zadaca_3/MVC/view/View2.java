package mkralj_zadaca_3.MVC.view;

public class View2 extends View {

    private int brojRetka = 0;
    
    @Override
    public void print(String printingData) {
        String[] splitByEndOfLine = printingData.split("\n");
        for(String str : splitByEndOfLine){
            System.out.format("[%05d] %s\n", ++brojRetka, str);
        }
        
    }
} 
