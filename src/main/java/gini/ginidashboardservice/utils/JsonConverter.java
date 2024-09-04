package gini.ginidashboardservice.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.io.IOException;

@Converter
public class JsonConverter<T> implements AttributeConverter<T, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(T attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Could not convert attribute to JSON string: " + attribute, e);
        }
    }

    @Override
    public T convertToEntityAttribute(String dbData) {
        try {
            return (T) objectMapper.readValue(dbData, Object.class);
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not convert JSON string to attribute: " + dbData, e);
        }
    }
}
