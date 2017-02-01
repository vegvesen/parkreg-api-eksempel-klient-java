package no.vegvesen.tk.parkreg.apiklient.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import no.vegvesen.tk.parkreg.apiklient.serializers.DateTimeDeserializer;
import no.vegvesen.tk.parkreg.apiklient.serializers.DateTimeSerializer;

import java.time.ZonedDateTime;

public class Deaktivert {

    private ZonedDateTime deaktivertTidspunkt;

    @JsonDeserialize(using=DateTimeDeserializer.class)
    public void setDeaktivertTidspunkt(ZonedDateTime deaktivertTidspunkt) {
        this.deaktivertTidspunkt = deaktivertTidspunkt;
    }

    @JsonSerialize(using=DateTimeSerializer.class)
    public ZonedDateTime getDeaktivertTidspunkt() {
        return deaktivertTidspunkt;
    }
}
