package mkralj_zadaca_3.tablePrinter;

import java.util.ArrayList;

public class Row implements IRow {

    protected String[] columns = {"", "", ""};
    protected ArrayList<String[]> rows = new ArrayList<>();

    public Row() {
        columns[0] = String.format(TableInitialData.PROGRAM_DATA, "Program");
        columns[1] = String.format(TableInitialData.DAN_DATA, "Dan");
        columns[2] = String.format(TableInitialData.EMISIJA_DATA, "Emisija");
        
        rows.add(columns);
    }
    
    @Override
    public ArrayList<String[]> getRows() {
        return rows;
    }
}
