package mkralj_zadaca_3.program;

import java.time.LocalDateTime;

public class Program {

    private int idProgram;
    private String imePrograma;
    private LocalDateTime pocetakPrikazivanjaProg;
    private LocalDateTime zavrsetakPrikazivanjaProg;
    private String nazivDatoteke;

    public void setIdProgram(int idProgram) {
        this.idProgram = idProgram;
    }

    public void setImePrograma(String imePrograma) {
        this.imePrograma = imePrograma;
    }

    public void setPocetakPrikazivanjaProg(LocalDateTime pocetakPrikazivanjaProg) {
        if (this.getZavrsetakPrikazivanjaProg() != null && pocetakPrikazivanjaProg.isAfter(this.getZavrsetakPrikazivanjaProg())) {
            this.zavrsetakPrikazivanjaProg = zavrsetakPrikazivanjaProg.plusDays(1);
        }

        this.pocetakPrikazivanjaProg = pocetakPrikazivanjaProg;
    }

    public void setZavrsetakPrikazivanjaProg(LocalDateTime zavrsetakPrikazivanjaProg) {
        if (this.getPocetakPrikazivanjaProg() != null && getPocetakPrikazivanjaProg().isAfter(zavrsetakPrikazivanjaProg)) {
            this.zavrsetakPrikazivanjaProg = zavrsetakPrikazivanjaProg.plusDays(1);
        } else {
            this.zavrsetakPrikazivanjaProg = zavrsetakPrikazivanjaProg;
        }
    }

    public void setNazivDatoteke(String nazivDatoteke) {
        this.nazivDatoteke = nazivDatoteke;
    }

    public int getIdProgram() {
        return idProgram;
    }

    public String getImePrograma() {
        return imePrograma;
    }

    public LocalDateTime getPocetakPrikazivanjaProg() {
        return pocetakPrikazivanjaProg;
    }

    public LocalDateTime getZavrsetakPrikazivanjaProg() {
        return zavrsetakPrikazivanjaProg;
    }

    public String getNazivDatoteke() {
        return nazivDatoteke;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(imePrograma).append('[')
                .append(pocetakPrikazivanjaProg).append('-').
                append(zavrsetakPrikazivanjaProg).append(']');
        return sb.toString();
    }
}
