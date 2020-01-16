package mkralj_zadaca_3.program;

import java.time.LocalTime;
import java.util.ArrayList;

public class PopunjenostDana {
/*
    float popunjenostEmisijama = 0;
    float slobodnoVrijeme = 0;
    float emitiranjeSignala = 0;
    
    public PopunjenostDana(ArrayList<EmisijaZaPrikaz> emisijePoRasporedu, ProgramAttributes atributi) {
        izracunajPopunjenost(emisijePoRasporedu, atributi);
    }

    private void izracunajPopunjenost(ArrayList<EmisijaZaPrikaz> emisijePoRasporedu, ProgramAttributes atributi) {
        int secTrajanjeSvihEmisija = 1;
        int slobodnoVrijemeUk = 1;
        for(EmisijaZaPrikaz emisija : emisijePoRasporedu){
            secTrajanjeSvihEmisija += emisija.getEmisija().getTrajanje()*60;
        }
        slobodnoVrijemeUk = izracunajUkupnoSlobodnoVrijeme(secTrajanjeSvihEmisija, atributi);
        
        float cijeliDanSec = 24*60*60;
        this.popunjenostEmisijama = (secTrajanjeSvihEmisija/cijeliDanSec)*100;
        this.slobodnoVrijeme = (slobodnoVrijemeUk/cijeliDanSec)*100;
        this.emitiranjeSignala = 100-popunjenostEmisijama-slobodnoVrijeme;
    }

    private int izracunajUkupnoSlobodnoVrijeme(int secTrajanjeSvihEmisija, ProgramAttributes atributi) {
        int zbrojVremenaDoZavrsetkaSec = 0;
        LocalTime pocetakPrikazivanja = atributi.getPocetakPrikazivanjaProg();
        LocalTime zavrsetakPrikazivanja = atributi.getZavrsetakPrikazivanjaProg();
        if(pocetakPrikazivanja.isAfter(zavrsetakPrikazivanja))
            zbrojVremenaDoZavrsetkaSec = zbrojiVrijemeInv(pocetakPrikazivanja, zavrsetakPrikazivanja);
        else
            zbrojVremenaDoZavrsetkaSec = zbrojiVrijeme(pocetakPrikazivanja, zavrsetakPrikazivanja);
        
        return zbrojVremenaDoZavrsetkaSec - secTrajanjeSvihEmisija;
    
    }

    private int zbrojiVrijemeInv(LocalTime pocetakPrikazivanja, LocalTime zavrsetakPrikazivanja) {
        int zbrojVremenaSec = LocalTime.MAX.minusHours(pocetakPrikazivanja.getHour()).minusMinutes(pocetakPrikazivanja.getMinute())
                .minusSeconds(pocetakPrikazivanja.getSecond()).toSecondOfDay();

        return zbrojVremenaSec+=zavrsetakPrikazivanja.toSecondOfDay();
    }

    private int zbrojiVrijeme(LocalTime pocetakPrikazivanja, LocalTime zavrsetakPrikazivanja) {
        return zavrsetakPrikazivanja.minusHours(pocetakPrikazivanja.getHour()).minusMinutes(pocetakPrikazivanja.getMinute())
                .minusSeconds(pocetakPrikazivanja.getSecond()).toSecondOfDay();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Popunjenost emisijama: ").append(popunjenostEmisijama).append("%\n\tSlobodno vrijeme: ")
                .append(slobodnoVrijeme).append("%\n\tEemitiranje signala: ").append(emitiranjeSignala).append("%");
        return sb.toString();
    }
    */
    
}
