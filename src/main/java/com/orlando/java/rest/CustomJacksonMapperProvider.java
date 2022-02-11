package com.orlando.java.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CustomJacksonMapperProvider implements ContextResolver<ObjectMapper> {

  final ObjectMapper mapper;

  public CustomJacksonMapperProvider() {
    mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
  }

  @Override
  public ObjectMapper getContext(Class<?> aClass) {
    return mapper;
  }
}
