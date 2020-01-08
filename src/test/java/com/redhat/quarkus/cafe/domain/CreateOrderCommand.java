package com.redhat.quarkus.cafe.domain;

import java.util.List;
import java.util.Optional;

public class CreateOrderCommand {

    String id;

    Optional<List<Beverage>> beverages;

    Optional<List<Food>> foods;

    public CreateOrderCommand(String id, Optional<List<Beverage>> beverages, Optional<List<Food>> foods) {
        this.id = id;
        this.beverages = beverages;
        this.foods = foods;
    }
}
