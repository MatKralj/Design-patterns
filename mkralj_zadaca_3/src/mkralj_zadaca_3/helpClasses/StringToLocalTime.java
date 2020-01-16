package mkralj_zadaca_3.helpClasses;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class StringToLocalTime {

    public LocalDateTime convert(String str) {
        String[] splitHoursMins = str.split(":");

        try {
            switch (splitHoursMins.length) {
                case 1:
                    return manageOneArg(splitHoursMins);
                case 2:
                    return manageTwoArgs(splitHoursMins);
                case 3:
                    return manageThreeArgs(splitHoursMins);
            }
        } catch (Exception ex) {
            return null;
        }
        
        return null;
    }

    private LocalDateTime manageOneArg(String[] splitHoursMins) {
        StringToInt strToInt = new StringToInt();
        int hours = strToInt.convert(splitHoursMins[0].trim());

        LocalDateTime returnMe = LocalDateTime.of(2000, 1, 1, hours, 0);

        return returnMe;
    }

    private LocalDateTime manageTwoArgs(String[] splitHoursMins) {
        StringToInt strToInt = new StringToInt();
        int hours = strToInt.convert(splitHoursMins[0].trim());
        int minutes = strToInt.convert(splitHoursMins[1].trim());

        LocalDateTime returnMe = LocalDateTime.of(2000, 1, 1, hours, minutes);

        return returnMe;

    }

    private LocalDateTime manageThreeArgs(String[] splitHoursMins) {
        StringToInt strToInt = new StringToInt();
        int hours = strToInt.convert(splitHoursMins[0].trim());
        int minutes = strToInt.convert(splitHoursMins[1].trim());
        int sec = strToInt.convert(splitHoursMins[2].trim());
        LocalDateTime returnMe = LocalDateTime.of(2000, 1, 1, hours, minutes, sec);

        return returnMe;
    }
}
