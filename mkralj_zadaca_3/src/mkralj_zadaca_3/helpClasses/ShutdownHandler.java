package mkralj_zadaca_3.helpClasses;

public class ShutdownHandler {
    
    public void addShutdownHook(){
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("-------------\n"
                        + "Aplikacija zavrsava s radom."
                        + "\n-------------");
                ErrorTracker eTracker = ErrorTracker.getTracker();
                if(eTracker.hasErrors()){
                    System.out.println(eTracker.getErrorTrack());
                }
                
            }
        }));
    }
}
