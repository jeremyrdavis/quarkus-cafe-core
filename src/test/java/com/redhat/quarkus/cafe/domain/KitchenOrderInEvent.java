package com.redhat.quarkus.cafe.domain;

public class KitchenOrderInEvent implements CafeEvent {

    String orderId;

    Food food;

    public KitchenOrderInEvent(String orderId, Food food) {
        this.orderId = orderId;
        this.food = food;
    }
}
