package mkralj_zadaca_3.tablePrinter;

import java.util.ArrayList;
import mkralj_zadaca_3.helpClasses.DanUTjednuHelper.Dan;

public class DanColumn extends RowDecorator {

    private final Dan dan;
    private String data = "";
    
    public DanColumn(IRow row, Dan dan) {
        super(row);
        this.dan = dan;

        addToRow();
    }

    private void addToRow() {
        data = String.format(TableInitialData.DAN_DATA, this.dan.toString());

        super.addToRow(this, 1);
    }

    @Override
    public String getDecoratorData() {
        return data;
    }
}
