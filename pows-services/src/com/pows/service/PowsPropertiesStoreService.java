package com.pows.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/ps")
public class PowsPropertiesStoreService {

    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "This is POWS Properties Store Service Root Path";
    }
}
