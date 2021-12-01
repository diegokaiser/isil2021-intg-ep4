package pe.isil.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class Formatter {

    private final ObjectMapper objectMapper;

    public Formatter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String toString(Object o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
