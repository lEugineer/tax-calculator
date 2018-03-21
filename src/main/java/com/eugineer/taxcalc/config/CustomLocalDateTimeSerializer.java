package com.eugineer.taxcalc.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomLocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
    @Override
    public void serialize ( LocalDateTime dateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider ) throws IOException {
        String formattedDateTime = dateTime.format( DateTimeFormatter.ISO_DATE_TIME);
        jsonGenerator.writeString( formattedDateTime );
    }
}
