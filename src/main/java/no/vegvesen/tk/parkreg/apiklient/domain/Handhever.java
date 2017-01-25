package no.vegvesen.tk.parkreg.apiklient.domain;

public class Handhever {

    private String organisasjonsnummer;
    private String navn;

    public String getOrganisasjonsnummer() {
        return organisasjonsnummer;
    }

    public void setOrganisasjonsnummer(String organisasjonsnummer) {
        this.organisasjonsnummer = organisasjonsnummer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
