package com.orlando.java.rest2;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

@Path("/json")
public class JsonResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response hello() {
    JSONObject json = new JSONObject();
    json.put("result", "Jersey JSON example using MOXy");

    return Response.status(Response.Status.OK).entity(json.toString()).build();
  }

  @Path("/{name}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public User hello(@PathParam("name") String name) {
    return new User(1, name);
  }

  @Path("/all")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<User> helloList() {
    return Arrays.asList(new User(1, "Orlando"), new User(2, "Aaron"));
  }

  @Path("/create")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response create(User user) {
    JSONObject json = new JSONObject();
    json.put("status", "ok");
    return Response.status(Response.Status.OK).entity(json.toString()).build();
  }

}
