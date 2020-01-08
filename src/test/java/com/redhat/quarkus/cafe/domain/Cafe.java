package com.redhat.quarkus.cafe.domain;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Cafe {

    //TODO Create and persist an Order
    public List<CafeEvent> orderIn(CreateOrderCommand createOrderCommand) {
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
        return retVal;
    }
}
