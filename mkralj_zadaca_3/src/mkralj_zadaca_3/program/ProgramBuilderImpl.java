package mkralj_zadaca_3.program;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ProgramBuilderImpl implements ProgramBuilder {

    private Program program;

    public ProgramBuilderImpl() {
        program = new Program();
    }

    @Override
    public Program build() {
        return this.program;
    }

    @Override
    public ProgramBuilder setProgramId(int id) {
        this.program.setIdProgram(id);
        return this;
    }

    @Override
    public ProgramBuilder setProgramName(String name) {
        this.program.setImePrograma(name);
        return this;
    }

    @Override
    public ProgramBuilder setProgramStartTime(LocalDateTime time) {
        this.program.setPocetakPrikazivanjaProg(time);
        return this;
    }

    @Override
    public ProgramBuilder setProgramEndTime(LocalDateTime time) {
        this.program.setZavrsetakPrikazivanjaProg(time);
        return this;
    }

    @Override
    public ProgramBuilder setProgramFileName(String fileName) {
        this.program.setNazivDatoteke(fileName);
        return this;
    }
}
