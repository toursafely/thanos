package com.toursafely.thanos.resource;

import com.codahale.metrics.annotation.Timed;
import com.toursafely.thanos.api.User;
import com.toursafely.thanos.model.LoginRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
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
    @Path("/{userId}")
    @Timed
    public User getUser(@PathParam("userId") String userId) {
        return new User();
    }

    @POST
    @Timed
    public User createUser(User user) {
        return new User();
    }

    @PUT
    @Timed
    public User updateUser(User user) {
        return user;
    }

    @POST
    @Timed
    @Path("/login")
    public User login(LoginRequest loginRequest) {
        return new User();
    }
}
