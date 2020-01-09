package com.redhat.quarkus.cafe.infrastructure;

import com.redhat.quarkus.cafe.domain.*;
import io.vertx.core.Vertx;
import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.kafka.client.producer.KafkaProducerRecord;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestResource {

    Logger logger = Logger.getLogger(RestResource.class);

    @Inject
    Cafe cafe;

    Jsonb jsonb = JsonbBuilder.create();

    @GET
    public String hello() {
        return "hello";
    }

    @POST
    public CompletableFuture<Response> orderIn(CreateOrderCommand createOrderCommand) {

        logger.debug(createOrderCommand);
        return cafe.orderIn(createOrderCommand).thenApply(e -> {
            System.out.println(e);
            System.out.println(jsonb.toJson(e));
            return Response.accepted().build();
        });
    }

}