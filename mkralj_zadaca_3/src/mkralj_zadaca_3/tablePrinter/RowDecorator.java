package mkralj_zadaca_3.tablePrinter;

import java.util.ArrayList;

public abstract class RowDecorator implements IRow{

    private final IRow rowsData;

    public RowDecorator(IRow row){
        this.rowsData = row;
    }

    @Override
    public ArrayList<String[]> getRows(){
        return this.rowsData.getRows();
    }
    
    public abstract String getDecoratorData();
    
    protected void addToRow(RowDecorator decorator, int column){
        if(rowsData==null)
            return;
        ArrayList<String[]> rows = rowsData.getRows();
        
        boolean isRowFinished = false;
        for(String[] row : rows){
            if(row[column]==null || row[column].isBlank()){
                isRowFinished = false;
                break;
            }
            else{
                isRowFinished = true;
            }
        }
        
        if(isRowFinished){
            String col0 = String.format(TableInitialData.PROGRAM_DATA, "");
            String col1 = String.format(TableInitialData.DAN_DATA, "");
            String col2 = String.format(TableInitialData.EMISIJA_DATA, "");
            String[] emptyRow = {col0, col1, col2};
            rows.add(emptyRow);
        }
        String[] lastRow = rows.get(rows.size()-1);
        lastRow[column] = decorator.getDecoratorData();
    }
}
