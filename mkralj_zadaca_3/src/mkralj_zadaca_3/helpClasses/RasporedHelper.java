package mkralj_zadaca_3.helpClasses;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import mkralj_zadaca_3.emisija.EmisijaZaPrikaz;
import mkralj_zadaca_3.helpClasses.DanUTjednuHelper.Dan;
import mkralj_zadaca_3.iterator.Iterabl;
import mkralj_zadaca_3.iterator.Iterator;
import mkralj_zadaca_3.program.Program;
import mkralj_zadaca_3.rasporedComposite.DanElementComposite;
import mkralj_zadaca_3.rasporedComposite.EmisijaElement;
import mkralj_zadaca_3.rasporedComposite.ProgramComposite;
import mkralj_zadaca_3.rasporedComposite.ProgramElement;
import mkralj_zadaca_3.rasporedComposite.RasporedComponent;

public class RasporedHelper implements Iterabl<EmisijaElement> {

    private final Program program;
    private ArrayList<EmisijaElement> elementiPrograma;
    private final DanUTjednuHelper.Dan dan;

    private final LocalDateTime vrijemePocetkaProg;
    private final LocalDateTime vrijemeZavrsetkaProg;
    private final ProgramComposite parent;

    public RasporedHelper(ProgramComposite parent, DanUTjednuHelper.Dan dan, ArrayList<RasporedComponent> elementiPrograma) {
        this.program = parent.getProgram();
        this.dan = dan;
        this.elementiPrograma = ((ArrayList) elementiPrograma);
        this.parent = parent;

        this.vrijemePocetkaProg = this.program.getPocetakPrikazivanjaProg();
        this.vrijemeZavrsetkaProg = this.program.getZavrsetakPrikazivanjaProg();
    }

    public void rasporediEmisije() {
        Collections.sort(elementiPrograma);

        rasporediEmisijeKojeImajuDan();

        pokusajDodatiEmisijeBezDana();
    }

    private void rasporediEmisijeKojeImajuDan() {
        Iterator<EmisijaElement> elementi = createIterator();
        while (elementi.hasNext()) {
            EmisijaElement emEl = elementi.next();

            if (emEl.getEmisija().getPocetakEmisije() == null) {
                if (pokusajEmisijiDodatiVrijeme(emEl)) {
                    Collections.sort(elementiPrograma);
                }
            }
        }
    }

    private boolean pokusajEmisijiDodatiVrijeme(EmisijaElement emEl) {
        if (pokusajDodatiKodPocetkaPrograma(emEl)) {
            return true;
        } else if (pokusajDodatiIzmeduEmisija(emEl)) {
            return true;
        } else if (pokusajDodatiNakonZadnjeEmisije(emEl)) {
            return true;
        }

        this.elementiPrograma.remove(emEl);

        return false;
    }

    private boolean pokusajDodatiKodPocetkaPrograma(EmisijaElement emEl) {
        EmisijaZaPrikaz emisija = emEl.getEmisija();
        LocalDateTime vrijemePrveEmisije = null;

        if (this.elementiPrograma != null && !this.elementiPrograma.isEmpty()) {
            vrijemePrveEmisije = this.elementiPrograma.get(0).getEmisija().getPocetakEmisije();
        }
        if (vrijemePrveEmisije == null) {
            vrijemePrveEmisije = this.vrijemeZavrsetkaProg;
        }

        if (nemaPreklapanja(this.vrijemePocetkaProg, vrijemePrveEmisije, emisija.getEmisija().getTrajanje())) {
            emisija.setPocetakEmisije(this.vrijemePocetkaProg);

            return true;
        }

        return false;
    }

    private boolean pokusajDodatiIzmeduEmisija(EmisijaElement emEl) {
        EmisijaZaPrikaz emisija = emEl.getEmisija();
        EmisijaZaPrikaz trenutnaEmisija = null;
        EmisijaZaPrikaz sljedecaEmisija = null;
        if (this.elementiPrograma != null && !this.elementiPrograma.isEmpty()) {
            Iterator<EmisijaElement> iterator = createIterator();
            while (iterator.hasNext()) {
                trenutnaEmisija = iterator.next().getEmisija();

                int lastIndex = iterator.getPosition();
                sljedecaEmisija = null;
                if (iterator.hasNext()) {
                    sljedecaEmisija = iterator.next().getEmisija();
                }
                iterator.setPosition(lastIndex);

                if ((trenutnaEmisija != null && trenutnaEmisija.getPocetakEmisije() != null)
                        && (sljedecaEmisija != null && sljedecaEmisija.getPocetakEmisije() != null)) {
                    if (nemaPreklapanja(trenutnaEmisija.getZavrsetakEmisije(), sljedecaEmisija.getPocetakEmisije(), emisija.getEmisija().getTrajanje())) {
                        emisija.setPocetakEmisije(trenutnaEmisija.getZavrsetakEmisije());
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    private boolean pokusajDodatiNakonZadnjeEmisije(EmisijaElement emEl) {
        EmisijaZaPrikaz emisija = emEl.getEmisija();
        LocalDateTime zavrsZadnjeEm = null;
        if ((zavrsZadnjeEm = getZadnjuEmisijuSaZavrsetkom()) == null) {
            zavrsZadnjeEm = this.vrijemePocetkaProg;
        }

        if (nemaPreklapanja(zavrsZadnjeEm, this.vrijemeZavrsetkaProg, emisija.getEmisija().getTrajanje())) {
            emisija.setPocetakEmisije(zavrsZadnjeEm);
            return true;
        }

        return false;
    }

    private boolean nemaPreklapanja(LocalDateTime manjeVrijeme, LocalDateTime veceVrijeme, int trajanjeEMisije) {
        LocalDateTime novoManjeVrijeme = LocalDateTime.from(manjeVrijeme);
        novoManjeVrijeme = novoManjeVrijeme.plusMinutes(trajanjeEMisije);
        if (novoManjeVrijeme.isBefore(veceVrijeme) || novoManjeVrijeme.equals(veceVrijeme)) {
            return true;
        }

        return false;
    }

    private LocalDateTime getZadnjuEmisijuSaZavrsetkom() {
        EmisijaZaPrikaz emisija = null;
        LocalDateTime zavrsetak = null;
        if (this.elementiPrograma != null && !this.elementiPrograma.isEmpty()) {
            for (int i = (this.elementiPrograma.size() - 1); i >= 0; i--) {
                emisija = this.elementiPrograma.get(i).getEmisija();
                zavrsetak = emisija.getZavrsetakEmisije();
                if (zavrsetak != null) {
                    return zavrsetak;
                }
            }

        }
        return null;
    }

    private boolean pokusajEmisijiDodatiVrijemeIDan(EmisijaElement emEl) {
        if (pokusajDodatiKodPocetkaPrograma(emEl)) {
            return true;
        } else if (pokusajDodatiIzmeduEmisija(emEl)) {
            return true;
        } else if (pokusajDodatiNakonZadnjeEmisije(emEl)) {
            return true;
        }
        return false;
    }

    private void pokusajDodatiEmisijeBezDana() {
        try {
            DanElementComposite elementiBezDana = (DanElementComposite) this.parent.findDay(Dan.NULL);
            if (elementiBezDana == null || elementiBezDana.getElementiPrograma().isEmpty()) {
                return;
            }
            Iterator<EmisijaElement> elementiBezDanaIterator = createIterator();
            while (elementiBezDanaIterator.hasNext()) {
                EmisijaElement emEl = elementiBezDanaIterator.next();

                if (emEl.getEmisija().getPocetakEmisije() == null) {
                    if (pokusajEmisijiDodatiVrijemeIDan(emEl)) {
                        elementiBezDanaIterator.remove();
                        Collections.sort(elementiPrograma);
                    }
                }
            }
        } catch (Exception ex) {
        }
    }

    @Override
    public Iterator<EmisijaElement> createIterator() {
        return new RasporedHelpterIterator();
    }

    class RasporedHelpterIterator implements Iterator<EmisijaElement> {

        private int currentPosition = 0;

        @Override
        public boolean hasNext() {
            if (elementiPrograma == null || currentPosition >= elementiPrograma.size()) {
                return false;
            }

            return true;
        }

        @Override
        public EmisijaElement next() {
            return elementiPrograma.get(currentPosition++);
        }

        @Override
        public void remove() {
            if (currentPosition <= 0) {
                throw new IllegalStateException("Pozicija je manja od 0");
            }
            if (elementiPrograma.get(currentPosition - 1) != null) {
                for (int i = currentPosition - 1; i < (elementiPrograma.size() - 1); i++) {
                    elementiPrograma.set(i, elementiPrograma.get(i + 1));
                }

                elementiPrograma.remove(elementiPrograma.size() - 1);

                if (elementiPrograma.size() == currentPosition && elementiPrograma.size() > 0) {
                    currentPosition--;
                }
            }
        }

        @Override
        public void setPosition(int p) {
            this.currentPosition = p;
        }

        @Override
        public int getPosition() {
            return this.currentPosition;
        }

    }
}
