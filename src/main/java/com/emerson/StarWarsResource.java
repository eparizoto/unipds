package com.emerson;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.awt.*;

@Path("/starwars")
@Produces(MediaType.APPLICATION_JSON)
public class StarWarsResource {

    @RestClient
    StarWarsService starWarsService;

    @GET
    @Path("/starships")
    public String getStarships() {
        return starWarsService.getStarships();
    }

}
