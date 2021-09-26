package backend.Shop.domain.controller;

import backend.Shop.domain.OrderService;

public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


}
