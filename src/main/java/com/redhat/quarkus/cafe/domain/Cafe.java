package com.redhat.quarkus.cafe.domain;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class Cafe {

    //TODO Create and persist an Order
    public List<CafeEvent> orderIn(CreateOrderCommand createOrderCommand) {
        List<CafeEvent> allEvents = new ArrayList<>();
        createOrderCommand.beverages.ifPresent(beverages -> {
            allEvents.addAll(createOrderCommand.beverages.get().stream().map(b -> new BeverageOrderInEvent(createOrderCommand.id, b)).collect(Collectors.toList()));
        });
        createOrderCommand.foods.ifPresent(foods -> {
            allEvents.addAll(createOrderCommand.foods.get().stream().map(f -> new KitchenOrderInEvent(createOrderCommand.id, f)).collect(Collectors.toList()));
        });
        return allEvents;
    }
}
