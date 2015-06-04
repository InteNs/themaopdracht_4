package domain;

import java.util.HashMap;


public class Order {
    @SuppressWarnings("unused")
    private final HashMap<Object, Integer> orderList;

    public Order(HashMap<Object, Integer> orderList) {
        this.orderList = orderList;
    }
}
