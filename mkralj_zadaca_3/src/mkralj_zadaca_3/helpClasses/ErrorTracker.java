package mkralj_zadaca_3.helpClasses;

public class ErrorTracker {

    private volatile static ErrorTracker tracker = null;
    private String errorTrack = "";

    private ErrorTracker() {
    }

    public static ErrorTracker getTracker() {
        if (tracker == null) {
            synchronized (ErrorTracker.class) {
                if (tracker == null) {
                    tracker = new ErrorTracker();
                }
            }
        }
        return tracker;
    }

    public void addErrorTrack(String errorMessage) {
        synchronized (ErrorTracker.class) {
            System.out.println(errorMessage);
            errorTrack += errorMessage + "\n";
        }
    }

    public String getErrorTrack() {
        return "Greske koje su se pojavile: " + errorTrack;
    }

    boolean hasErrors() {
        if (errorTrack.isEmpty()) {
            return false;
        }
        return true;
    }
}
