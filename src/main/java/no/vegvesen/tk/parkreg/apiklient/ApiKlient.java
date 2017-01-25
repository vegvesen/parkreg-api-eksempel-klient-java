package no.vegvesen.tk.parkreg.apiklient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.vegvesen.tk.parkreg.apiklient.domain.Innfartsparkering;
import no.vegvesen.tk.parkreg.apiklient.domain.Parkeringsomrade;
import no.vegvesen.tk.parkreg.apiklient.domain.ParkeringsomradeVersjon;
import no.vegvesen.tk.parkreg.apiklient.domain.TypeParkeringsomrade;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.math.BigDecimal;
import java.net.URL;

public class ApiKlient {

    private static final String LOCALHOST_URL = "http://localhost:8020/ws/no/vegvesen/veg/parkeringsomraade/parkeringsregisteret_internbruker/v1/parkeringsomraade";

    public static void main(String... args) throws JsonProcessingException {
        Client client = ClientBuilder.newBuilder()
                .register(MultiPartFeature.class)
                .build();

        Parkeringsomrade inputOmrade = opprettParkeringsomrade();

        FileDataBodyPart skiltplanPart = new FileDataBodyPart("skiltplanfil", getSkiltplanFil());
        MultiPart multipart = new FormDataMultiPart()
                .field("parkeringsomraade", inputOmrade, MediaType.APPLICATION_JSON_TYPE)
                .bodyPart(skiltplanPart);

        WebTarget target = client.target(LOCALHOST_URL);
        Response response = target
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("User-ID", "TjeOsloParkering_Parkeringsregisteret")
                .post(Entity.entity(multipart, multipart.getMediaType()));

        if (response.getStatus() == 200) {
            Parkeringsomrade parkeringsomrade = response.readEntity(Parkeringsomrade.class);

            ObjectMapper mapper = new ObjectMapper();
            System.out.println(mapper.writeValueAsString(parkeringsomrade));
        } else {
            System.out.println("Error code: " + response.getStatus());
            System.out.println(response.readEntity(String.class));
        }
    }

    private static File getSkiltplanFil() {
        ClassLoader classLoader = ApiKlient.class.getClassLoader();
        URL resourceUrl = classLoader.getResource("skiltplan.pdf");
        if (resourceUrl != null) {
            return new File(resourceUrl.getFile());
        }
        return null;
    }

    private static Parkeringsomrade opprettParkeringsomrade() {
        Parkeringsomrade parkeringsomrade = new Parkeringsomrade();
        parkeringsomrade.setBreddegrad(new BigDecimal(16.938445));
        parkeringsomrade.setLengdegrad(new BigDecimal(54.537850));

        ParkeringsomradeVersjon versjon = new ParkeringsomradeVersjon();
        versjon.setAntallAvgiftsbelagtePlasser(200);
        versjon.setAntallAvgiftsfriePlasser(180);
        versjon.setAntallForflytningshemmede(10);
        versjon.setAntallLadeplasser(20);
        versjon.setInnfartsparkering(Innfartsparkering.NEI);
        versjon.setTypeParkeringsomrade(TypeParkeringsomrade.PARKERINGSHUS);
        versjon.setVurderingForflytningshemmede("En vurdering etter paragraf 62...");
        versjon.setAdresse("Kongeveien 10");
        versjon.setPostnummer("0100");
        versjon.setPoststed("OSLO");
        versjon.setNavn("Kongen P-HUS");

        parkeringsomrade.setAktivVersjon(versjon);
        return parkeringsomrade;
    }
}
