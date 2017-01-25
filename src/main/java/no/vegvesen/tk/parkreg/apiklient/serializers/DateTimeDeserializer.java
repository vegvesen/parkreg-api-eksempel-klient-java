package no.vegvesen.tk.parkreg.apiklient.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.ZonedDateTime;

public class DateTimeDeserializer extends StdDeserializer<ZonedDateTime> {

    public DateTimeDeserializer() {
        super(ZonedDateTime.class);
    }

    @Override
    public ZonedDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken token = jsonParser.getCurrentToken();

        if (token == JsonToken.VALUE_STRING) {
            String str = jsonParser.getText().trim();
            if (str.length() == 0) {
                return null;
            }
            return ZonedDateTime.parse(str);
        }
        deserializationContext.handleUnexpectedToken(ZonedDateTime.class, jsonParser);
        return null;
    }
}
