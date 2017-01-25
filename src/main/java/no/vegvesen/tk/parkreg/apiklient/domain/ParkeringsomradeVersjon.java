package no.vegvesen.tk.parkreg.apiklient.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import no.vegvesen.tk.parkreg.apiklient.serializers.DateTimeDeserializer;
import no.vegvesen.tk.parkreg.apiklient.serializers.DateTimeSerializer;
import org.springframework.hateoas.Link;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParkeringsomradeVersjon {
    private AktiveringsValg aktiveringsvalg;
    private boolean publisert;

    private String navn;
    private String tilbydersOmradeId;
    private String adresse;
    private String postnummer;
    private String poststed;
    private Integer antallAvgiftsbelagtePlasser;
    private Integer antallAvgiftsfriePlasser;
    private Integer antallLadeplasser;
    private Integer antallForflytningshemmede;
    private String vurderingForflytningshemmede;
    private ZonedDateTime aktiveringstidspunkt;
    private ZonedDateTime sistEndret;
    private long skiltplanId;
    private List<Link> links = new ArrayList<>();
    private int versjonsnummer;
    private ZonedDateTime sluttidspunkt;
    private long opplastetVurderingId;
    private TypeParkeringsomrade typeParkeringsomrade;
    private Innfartsparkering innfartsparkering;
    private Handhever handhever;

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getTilbydersOmradeId() {
        return tilbydersOmradeId;
    }

    public void setTilbydersOmradeId(String tilbydersOmradeId) {
        this.tilbydersOmradeId = tilbydersOmradeId;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(String postnummer) {
        this.postnummer = postnummer;
    }

    public String getPoststed() {
        return poststed;
    }

    public void setPoststed(String poststed) {
        this.poststed = poststed;
    }

    public Integer getAntallAvgiftsbelagtePlasser() {
        return antallAvgiftsbelagtePlasser;
    }

    public void setAntallAvgiftsbelagtePlasser(Integer antallAvgiftsbelagtePlasser) {
        this.antallAvgiftsbelagtePlasser = antallAvgiftsbelagtePlasser;
    }

    public Integer getAntallLadeplasser() {
        return antallLadeplasser;
    }

    public void setAntallLadeplasser(Integer antallLadeplasser) {
        this.antallLadeplasser = antallLadeplasser;
    }

    public Integer getAntallForflytningshemmede() {
        return antallForflytningshemmede;
    }

    public void setAntallForflytningshemmede(Integer antallForflytningshemmede) {
        this.antallForflytningshemmede = antallForflytningshemmede;
    }

    public String getVurderingForflytningshemmede() {
        return vurderingForflytningshemmede;
    }

    public void setVurderingForflytningshemmede(String vurderingForflytningshemmede) {
        this.vurderingForflytningshemmede = vurderingForflytningshemmede;
    }

    @JsonSerialize(using=DateTimeSerializer.class)
    public ZonedDateTime getAktiveringstidspunkt() {
        return aktiveringstidspunkt;
    }

    @JsonDeserialize(using=DateTimeDeserializer.class)
    public void setAktiveringstidspunkt(ZonedDateTime aktiveringstidspunkt) {
        this.aktiveringstidspunkt = aktiveringstidspunkt;
    }

    @JsonSerialize(using=DateTimeSerializer.class)
    public ZonedDateTime getSistEndret() {
        return sistEndret;
    }

    @JsonDeserialize(using=DateTimeDeserializer.class)
    public void setSistEndret(ZonedDateTime sistEndret) {
        this.sistEndret = sistEndret;
    }

    public long getSkiltplanId() {
        return skiltplanId;
    }

    public void setSkiltplanId(long skiltplanId) {
        this.skiltplanId = skiltplanId;
    }

    public long getOpplastetVurderingId() {
        return opplastetVurderingId;
    }

    public void setOpplastetVurderingId(long opplastetVurderingId) {
        this.opplastetVurderingId = opplastetVurderingId;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void addLink(Link link) {
        links.add(link);
    }

    public int getVersjonsnummer() {
        return versjonsnummer;
    }

    public void setVersjonsnummer(int versjonsnummer) {
        this.versjonsnummer = versjonsnummer;
    }

    @JsonDeserialize(using=DateTimeDeserializer.class)
    public void setSluttidspunkt(ZonedDateTime sluttidspunkt) {
        this.sluttidspunkt = sluttidspunkt;
    }

    @JsonSerialize(using=DateTimeSerializer.class)
    public ZonedDateTime getSluttidspunkt() {
        return sluttidspunkt;
    }

    public Innfartsparkering getInnfartsparkering() {
        return innfartsparkering;
    }

    public void setInnfartsparkering(Innfartsparkering innfartsparkering) {
        this.innfartsparkering = innfartsparkering;
    }

    public TypeParkeringsomrade getTypeParkeringsomrade() {
        return typeParkeringsomrade;
    }

    public void setTypeParkeringsomrade(TypeParkeringsomrade typeParkeringsomrade) {
        this.typeParkeringsomrade = typeParkeringsomrade;
    }

    public Integer getAntallAvgiftsfriePlasser() {
        return antallAvgiftsfriePlasser;
    }

    public void setAntallAvgiftsfriePlasser(Integer antallAvgiftsfriePlasser) {
        this.antallAvgiftsfriePlasser = antallAvgiftsfriePlasser;
    }

    public Handhever getHandhever() {
        return handhever;
    }

    public void setHandhever(Handhever handhever) {
        this.handhever = handhever;
    }

    public AktiveringsValg getAktiveringsvalg() {
        return aktiveringsvalg;
    }

    public void setAktiveringsvalg(AktiveringsValg aktiveringsvalg) {
        this.aktiveringsvalg = aktiveringsvalg;
    }

    public boolean getPublisertStatus() {
        return publisert;
    }

    public void setPublisertStatus(boolean publisert) {
        this.publisert = publisert;
    }
}
