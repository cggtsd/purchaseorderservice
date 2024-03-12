package cgg.async.purchaseorderservice.services;

import org.springframework.stereotype.Service;

import cgg.async.purchaseorderservice.dto.Order;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentService {

    public void processPayment(Order order) throws InterruptedException {
        log.info("initiate payment for order " + order.getProductId());
        // call actual payment gateway
        Thread.sleep(2000l);
        log.info("completed payment for order " + order.getProductId());

    }
}
