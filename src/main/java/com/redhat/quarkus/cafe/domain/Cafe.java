package com.redhat.quarkus.cafe.domain;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class Cafe {

    //TODO Create and persist an Order
    public List<CafeEvent> orderIn(CreateOrderCommand createOrderCommand) {

/*
        CompletableFuture<List<CafeEvent>> orders =
                CompletableFuture.supplyAsync(() ->{
                    List<CafeEvent> retVal = new ArrayList<>();
                    if (createOrderCommand.beverages.isPresent()) {
                        createOrderCommand.beverages.get().stream().forEach(beverage -> {
                            retVal.add(new BeverageOrderInEvent(createOrderCommand.id, beverage));
                        });
                    }
                    if (createOrderCommand.foods.isPresent()) {
                        createOrderCommand.foods.get().stream().forEach(food -> {
                            retVal.add(new KitchenOrderInEvent(createOrderCommand.id, food));
                        });
                    }

                });
*/
        List<CafeEvent> allEvents = new ArrayList<>();
        if (createOrderCommand.beverages.isPresent()) {
            allEvents.addAll(createOrderCommand.beverages.get().stream().map(b -> new BeverageOrderInEvent(createOrderCommand.id, b)).collect(Collectors.toList()));
        }
//        createOrderCommand.foods.ifPresent(foods -> allEvents.addAll(foods.stream().map(f -> new KitchenOrderInEvent(createOrderCommand.id, f)).collect(Collectors.toList())));
        createOrderCommand.foods.ifPresent(foods -> System.out.println(foods));

        return allEvents;
    }
}
