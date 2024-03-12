package cgg.async.purchaseorderservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cgg.async.purchaseorderservice.dto.Order;
import cgg.async.purchaseorderservice.services.OrderFullfillmentService;

@RestController
@RequestMapping("/orders")
public class OrderFullfillmentController {

    private OrderFullfillmentService service;

    public OrderFullfillmentController(OrderFullfillmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Order> processOrder(@RequestBody Order order) throws InterruptedException {
        service.processOrder(order); // synchronous
        // asynchronous
        service.notifyUser(order);
        service.assignVendor(order);
        service.packaging(order);
        service.assignDeliveryPartner(order);
        service.assignTrailerAndDispatch(order);
        return ResponseEntity.ok(order);
    }
}
