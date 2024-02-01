package com.hprtech.ywddk.restclient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://www.antarvasnastory.net.in/wp-json/wp/v2")
public interface RestClient {
    @GET
    @Path("/media")
    public String getMedia(@QueryParam("per_page") int perPage, @QueryParam("page") int page);
}
