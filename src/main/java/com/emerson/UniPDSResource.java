package com.emerson;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/unipds")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class UniPDSResource {

    private int i = 0;

    @GET
    public int getI(String name) {
        return i;
    }

    @POST
    public void addI(int i) {
        i++;
    }

    @DELETE
    public void removeI(int i) {
        i--;
    }

    @PUT
    public void setI(int i) {
        this.i = i;
    }



}
