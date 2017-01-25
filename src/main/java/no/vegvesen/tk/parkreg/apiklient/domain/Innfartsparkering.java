package no.vegvesen.tk.parkreg.apiklient.domain;

public enum Innfartsparkering {

    IKKE_VALGT(0),
    JA(1),
    NEI(2);

    private int verdi;

    Innfartsparkering(int verdi) {
        this.verdi = verdi;
    }

    public int getVerdi() {
        return verdi;
    }
}
