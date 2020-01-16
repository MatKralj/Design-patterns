package mkralj_zadaca_3.tablePrinter;

import java.time.LocalDateTime;
import mkralj_zadaca_3.program.Program;

public class ProgramColumn extends RowDecorator{

    private final Program program;
    private String data = "";

    public ProgramColumn(IRow row, Program program) {
        super(row);
        this.program = program;

        
        addToRow();
    }

    @Override
    public String getDecoratorData() {
        return this.data;
    }

    private void addToRow() {
        LocalDateTime pocetakPrik = program.getPocetakPrikazivanjaProg();
        LocalDateTime zavrsetakPrik = program.getZavrsetakPrikazivanjaProg();
        data = String.format("%4d|%-18s|%2d:%2d-%2d:%2d|",
                program.getIdProgram(), program.getImePrograma(), pocetakPrik.getHour(), pocetakPrik.getMinute(),
                zavrsetakPrik.getHour(), zavrsetakPrik.getHour());
        
        super.addToRow(this, 0);
    }

}
