package no.vegvesen.tk.parkreg.apiklient.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Parkeringsomrade {

    private long id;

    private long parkeringstilbyderId;
    private String parkeringstilbyderNavn;
    private String parkeringstilbyderOrganisasjonsnummer;
    private BigDecimal breddegrad;
    private BigDecimal lengdegrad;
    private Deaktivert deaktivert;

    private ParkeringsomradeVersjon aktivVersjon;
    private List<ParkeringsomradeVersjon> historiskeVersjoner = new ArrayList<>();
    private List<ParkeringsomradeVersjon> fremtidigeVersjoner = new ArrayList<>();

    private boolean publisert;
    private boolean utkastLagret;


    public Parkeringsomrade() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ParkeringsomradeVersjon getAktivVersjon() {
        return aktivVersjon;
    }

    public void setAktivVersjon(ParkeringsomradeVersjon aktivVersjon) {
        this.aktivVersjon = aktivVersjon;
    }

    public List<ParkeringsomradeVersjon> getHistoriskeVersjoner() {
        return historiskeVersjoner;
    }

    public void setHistoriskeVersjoner(List<ParkeringsomradeVersjon> historiskeVersjoner) {
        this.historiskeVersjoner = historiskeVersjoner;
    }

    public void addHistoriskVersjon(ParkeringsomradeVersjon historiskVersjon) {
        historiskeVersjoner.add(historiskVersjon);
    }

    public BigDecimal getBreddegrad() {
        return breddegrad;
    }

    public void setBreddegrad(BigDecimal breddegrad) {
        this.breddegrad = breddegrad;
    }

    public BigDecimal getLengdegrad() {
        return lengdegrad;
    }

    public void setLengdegrad(BigDecimal lengdegrad) {
        this.lengdegrad = lengdegrad;
    }

    public Deaktivert getDeaktivert() {
        return deaktivert;
    }

    public void setDeaktivert(Deaktivert deaktivert) {
        this.deaktivert = deaktivert;
    }

    public long getParkeringstilbyderId() {
        return parkeringstilbyderId;
    }

    public void setParkeringstilbyderId(long parkeringstilbyderId) {
        this.parkeringstilbyderId = parkeringstilbyderId;
    }

    public String getParkeringstilbyderNavn() {
        return parkeringstilbyderNavn;
    }

    public void setParkeringstilbyderNavn(String parkeringstilbyderNavn) {
        this.parkeringstilbyderNavn = parkeringstilbyderNavn;
    }

    public String getParkeringstilbyderOrganisasjonsnummer() {
        return parkeringstilbyderOrganisasjonsnummer;
    }

    public void setParkeringstilbyderOrganisasjonsnummer(String parkeringstilbyderOrganisasjonsnummer) {
        this.parkeringstilbyderOrganisasjonsnummer = parkeringstilbyderOrganisasjonsnummer;
    }

    public List<ParkeringsomradeVersjon> getFremtidigeVersjoner() {
        return fremtidigeVersjoner;
    }

    public void setFremtidigeVersjoner(List<ParkeringsomradeVersjon> fremtidigeVersjoner) {
        this.fremtidigeVersjoner = fremtidigeVersjoner;
    }

    public void addFremtidigVersjon(ParkeringsomradeVersjon fremtidigVersjon) {
        fremtidigeVersjoner.add(fremtidigVersjon);
    }

    public boolean getPublisertStatus() {
        return publisert;
    }

    public void setPublisertStatus(boolean publisert) {
        this.publisert = publisert;
    }

    public boolean isUtkastLagret() {
        return utkastLagret;
    }

    public void setUtkastLagret(boolean utkastLagret) {
        this.utkastLagret = utkastLagret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parkeringsomrade that = (Parkeringsomrade) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}
