package com.redhat.quarkus.cafe.domain;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class CafeTest {


    @Inject
    Cafe cafe;

    @Test
    public void testOrderInBeverageOnly() throws ExecutionException, InterruptedException {

        List<Beverage> beverages = new ArrayList<>();
        List<Food> foods = new ArrayList<>();

        beverages.add(new Beverage());
        beverages.add(new Beverage());
        CreateOrderCommand createOrderCommand = new CreateOrderCommand(UUID.randomUUID().toString(), beverages, foods);
        List<CafeEvent> cafeEvents = cafe.orderIn(createOrderCommand);
        assertNotNull(cafeEvents);
        assertEquals(2, cafeEvents.size());
    }
}
