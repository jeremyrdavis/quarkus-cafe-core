package com.redhat.quarkus.cafe.domain;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@QuarkusTest
public class CafeTest {


    @Inject
    Cafe cafe;

    @Test
    public void testOrderInBeverageOnly() {

        List<Beverage> beverages = new ArrayList<>();
        List<Food> foods = new ArrayList<>();

        CreateOrderCommand createOrderCommand = new CreateOrderCommand(UUID.randomUUID().toString(), Optional.of(beverages), Optional.of(foods));

        List<CafeEvent> cafeEvents = cafe.orderIn(createOrderCommand);
    }
}
