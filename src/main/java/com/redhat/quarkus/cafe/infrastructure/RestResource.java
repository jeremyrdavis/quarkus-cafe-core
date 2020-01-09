package com.redhat.quarkus.cafe.infrastructure;

import com.redhat.quarkus.cafe.domain.Cafe;
import com.redhat.quarkus.cafe.domain.CafeEvent;
import com.redhat.quarkus.cafe.domain.CreateOrderCommand;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestResource {

    Logger logger = Logger.getLogger(RestResource.class);

    @Inject
    Cafe cafe;

    @GET
    public String hello() {
        return "hello";
    }

    @POST
    public Response orderIn(CreateOrderCommand createOrderCommand) {

        logger.debug(createOrderCommand);
        try {

            List<CafeEvent> eventList = cafe.orderIn(createOrderCommand);
        } catch (Exception e) {

            return Response.serverError().entity(e).build();
        }

        return Response.ok().build();
    }

}