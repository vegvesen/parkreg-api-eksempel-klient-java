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

public class ApiKlient {

    private static final String HOST = "http://localhost:8020";
    private static final String API_PATH = "/ws/no/vegvesen/veg/parkeringsomraade/parkeringsregisteret_internbruker/v1/parkeringsomraade";

    private static final String USER_ID = "TjeOsloParkering_Parkeringsregisteret";

    public static void main(String... args) throws JsonProcessingException {
        Client client = ClientBuilder.newBuilder()
                .register(MultiPartFeature.class)
                .build();

        Parkeringsomrade inputOmrade = opprettParkeringsomrade();

        FileDataBodyPart skiltplanPart = new FileDataBodyPart("skiltplanfil", getSkiltplanFil());
        MultiPart multipart = new FormDataMultiPart()
                .field("parkeringsomraade", inputOmrade, MediaType.APPLICATION_JSON_TYPE)
                .bodyPart(skiltplanPart);

        WebTarget target = client.target(HOST + API_PATH);
        Response response = target
                .request()
                .header("User-ID", USER_ID)
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
        return new File("./src/main/resources/skiltplan.pdf");
    }

    private static Parkeringsomrade opprettParkeringsomrade() {
        Parkeringsomrade parkeringsomrade = new Parkeringsomrade();
        parkeringsomrade.setBreddegrad(new BigDecimal(59.910316));
        parkeringsomrade.setLengdegrad(new BigDecimal(10.748299));

        ParkeringsomradeVersjon versjon = new ParkeringsomradeVersjon();
        versjon.setAntallAvgiftsbelagtePlasser(200);
        versjon.setAntallAvgiftsfriePlasser(180);
        versjon.setAntallForflytningshemmede(10);
        versjon.setAntallLadeplasser(40);
        versjon.setInnfartsparkering(Innfartsparkering.NEI);
        versjon.setTypeParkeringsomrade(TypeParkeringsomrade.PARKERINGSHUS);
        versjon.setVurderingForflytningshemmede("En vurdering etter paragraf 62...");
        versjon.setAdresse("Prinsens gate 1");
        versjon.setPostnummer("0152");
        versjon.setPoststed("OSLO");
        versjon.setNavn("Prinsen P-HUS");

        parkeringsomrade.setAktivVersjon(versjon);
        return parkeringsomrade;
    }
}
