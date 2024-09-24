package com.splunk.controller;
import com.splunk.dto.Order;
import com.splunk.service.OrderService;
import com.splunk.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private static final Logger logger = LogManager.getLogger(OrderController.class);

    private final OrderService service;

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        // Check if info logging is enabled before invoking the Mapper
        if (logger.isInfoEnabled()) {
            logger.info("OrderController:placeOrder persist order request {}", Mapper.mapToJsonString(order));
        }

        Order addOrder = service.addOrder(order);

        // Check if info logging is enabled before invoking the Mapper
        if (logger.isInfoEnabled()) {
            logger.info("OrderController:placeOrder response from service {}", Mapper.mapToJsonString(addOrder));
        }
        return addOrder;
    }


    @GetMapping
    public List<Order> getOrders() {
        List<Order> orders = service.getOrders();
        if (logger.isInfoEnabled()) {
            logger.info("OrderController:getOrders response from service {}", Mapper.mapToJsonString(orders));
        }
        return orders;
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        logger.info("OrderController:getOrder fetch order by id {}", id);
        Order order = service.getOrder(id);
        if (logger.isInfoEnabled()) {
            logger.info("OrderController:getOrder fetch order response {}", Mapper.mapToJsonString(order));
        }
        return order;
    }
}
