package com.pows.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/ts")
public class PowsTargetSystemService {
    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "This is POWS Target System Service Root Path";
    }
}
