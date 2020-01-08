package com.redhat.quarkus.cafe.domain;

public class BeverageOrderInEvent implements CafeEvent {

    String orderId;

    Beverage beverage;

    public BeverageOrderInEvent(String orderId, Beverage beverage) {

        this.orderId = orderId;
        this.beverage = beverage;
    }
}
