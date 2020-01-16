package mkralj_zadaca_3.program;

import java.time.LocalDateTime;
import java.time.LocalTime;

public interface ProgramBuilder {

    public Program build();
    public ProgramBuilder setProgramId(int id);
    public ProgramBuilder setProgramName(String name);
    public ProgramBuilder setProgramStartTime(LocalDateTime time);
    public ProgramBuilder setProgramEndTime(LocalDateTime time);
    public ProgramBuilder setProgramFileName(String fileName);
 
}
