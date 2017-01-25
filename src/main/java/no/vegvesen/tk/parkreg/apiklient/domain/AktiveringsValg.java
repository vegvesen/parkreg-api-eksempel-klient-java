package no.vegvesen.tk.parkreg.apiklient.domain;

public enum AktiveringsValg {
    
    IKKE_VALGT(0),
    VED_PUBLISERING(1),
    EGENDEFINERT(2);

    private int verdi;

    AktiveringsValg(int verdi) {
        this.verdi = verdi;
    }

    public int getVerdi() {
        return verdi;
    }
}
