package no.vegvesen.tk.parkreg.apiklient.domain;

public enum TypeParkeringsomrade {

    IKKE_VALGT(0),
    PARKERINGSHUS(1),
    LANGS_KJOREBANE(2),
    AVGRENSET_OMRADE(3);

    private int verdi;

    TypeParkeringsomrade(int verdi) {
        this.verdi = verdi;
    }

    public int getVerdi() {
        return verdi;
    }
}
