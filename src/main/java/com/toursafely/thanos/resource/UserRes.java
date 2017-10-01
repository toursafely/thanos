package com.toursafely.thanos.resource;

import com.codahale.metrics.annotation.Timed;
import com.toursafely.thanos.api.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserRes {

    private static final Logger LOG = LoggerFactory.getLogger(UserRes.class);

    public UserRes() {
        LOG.info("Initialized User resource");
    }

    @GET
    @Timed
    public User getUser() {
        return new User();
    }
}
