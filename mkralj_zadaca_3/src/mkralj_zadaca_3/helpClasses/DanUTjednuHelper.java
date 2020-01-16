package mkralj_zadaca_3.helpClasses;

import java.util.ArrayList;

public class DanUTjednuHelper {

    public static Dan DAN(int danBroj) {
        if (danBroj < 1 || danBroj > 7) {
            return null;
        }
        return Dan.values()[danBroj - 1];
    }

    public ArrayList getListOfDays(String rasponString) {
        ArrayList<Dan> returnList = new ArrayList<>();

        if (rasponString.contains("-")) {
            returnList = getDayArray(rasponString);
        } else if (rasponString.contains(",")) {
            returnList = getDayByDay(rasponString);
        } else {
            Dan singleDay = getSingleDay(rasponString);
            if (singleDay != null) {
                returnList.add(singleDay);
            }
        }

        return returnList;
    }

    private Dan getSingleDay(String danBroj) {
        StringToInt strToInt = new StringToInt();
        int dayNumber = strToInt.convert(danBroj.trim());

        return DAN(dayNumber);
    }

    private ArrayList<Dan> getDayByDay(String rasponString) {
        String[] splitString = rasponString.split(",");
        ArrayList<Dan> returnList = new ArrayList<>();

        for (int i = 0; i < splitString.length; i++) {
            Dan singleDay = getSingleDay(splitString[i]);
            if (singleDay != null) {
                returnList.add(singleDay);
            }
        }

        return returnList;
    }

    private ArrayList<Dan> getDayArray(String rasponString) {
        String[] splitString = rasponString.split("-");
        ArrayList<Dan> returnList = new ArrayList<>();

        Dan danFrom = getSingleDay(splitString[0]);
        Dan danDo = getSingleDay(splitString[1]);
        if (danFrom == null || danDo == null) {
            return null;
        }
        int fromDay = danFrom.getValue();
        int toDay = danDo.getValue();

        for (int i = fromDay; i <= toDay; i++) {
            returnList.add(DAN(i));
        }

        return returnList;
    }

    public enum Dan {
        PONEDJELJAK(1),
        UTORAK(2),
        SRIJEDA(3),
        CETVRTAK(4),
        PETAK(5),
        SUBOTA(6),
        NEDJELJA(7),
        NULL(8);

        private final int value;

        private Dan(final int newValue) {
            value = newValue;
        }

        public int getValue() {
            return value;
        }
    }
}
