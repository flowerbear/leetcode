package com.orlando.java.rest;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.grizzly.http.server.HttpServer;
import org.json.JSONException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.junit.jupiter.api.Assertions.*;

class JsonResourceTest {

  private static HttpServer server;

  private static WebTarget target;

  @BeforeAll
  public static void setUp() {
    server = MainApp.startHttpServer();
    Client c = ClientBuilder.newClient();
    target = c.target(MainApp.BASE_URI.toString());
  }

  @AfterAll
  public static void tearDown() {
    server.shutdownNow();
  }

  @Test
  public void testHello() throws JSONException {
    String actual = target.path("json").request().get(String.class);
    String expected = "{\"result\": \"Jersey JSON example using Jackson 2.x\"}";

    JSONAssert.assertEquals(expected, actual, false);
  }

  @Test
  public void testHelloName() throws JSONException {
    String response = target.path("json/orlando").request(MediaType.APPLICATION_JSON).get(String.class);

    String expected = "{\"id\":1,\"name\":\"orlando\"}";

    JSONAssert.assertEquals(expected, response, false);
  }

  @Test
  public void testHelloList() throws JSONException {
    String response = target.path("json/all").request(MediaType.APPLICATION_JSON).get(String.class);

    String expected = "[{\"id\":1,\"name\":\"Orlando\"},{\"id\":2,\"name\":\"Aaron\"}]";

    JSONAssert.assertEquals(expected, response, false);
  }

  @Test
  public void testCreateOk() throws JSONException{

    String json = "{\"id\": 1,\"name\":\"orlando\"}";

    Response response = target.path("json/create").request(MediaType.APPLICATION_JSON).post(Entity.entity(json, MediaType.valueOf("application/json")));

    assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());

    String acutal = response.readEntity(String.class);
    String expected = "{\"status\":\"ok\"}";

    JSONAssert.assertEquals(expected, acutal, false);
  }

  @Test
  public void testCreateError() throws JSONException{

    String json = "{\"id_no_field\": 1,\"name\":\"orlando\"}";

    Response response = target.path("json/create").request(MediaType.APPLICATION_JSON).post(Entity.entity(json, MediaType.valueOf("application/json")));

    assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());

    String acutal = response.readEntity(String.class);
    String expected = "{\"error\":\"json mapping error\"}";

    JSONAssert.assertEquals(expected, acutal, false);
  }
}