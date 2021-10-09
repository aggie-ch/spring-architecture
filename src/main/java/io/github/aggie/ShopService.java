package io.github.aggie;

import io.github.aggie.common.PagedResult;
import io.github.aggie.orders.Order;
import io.github.aggie.orders.OrderService;
import io.github.aggie.payments.Payment;
import io.github.aggie.payments.PaymentRequest;
import io.github.aggie.payments.PaymentService;
import io.github.aggie.products.Product;
import io.github.aggie.products.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@RequiredArgsConstructor
public class ShopService {

    private final OrderService orderService;
    private final PaymentService paymentService;
    private final ProductService productService;

    public Product addProduct(Product product) {
        return productService.add(product);
    }

    public List<Product> getByName(String name) {
        return productService.getByName(name);
    }

    public PagedResult<Product> getProducts(int pageNumber, int pageSize) {
        return productService.getAll(pageNumber, pageSize);
    }

    public Order placeOrder(Order order) {
        return orderService.add(order);
    }

    public Payment payForOrder(long orderId) {
        var order = orderService.getBy(orderId);
        var paymentRequest = PaymentRequest.builder()
                .money(order.getTotalPrice())
                .build();

        var payment = paymentService.process(paymentRequest);
        order.setPayment(payment);
        orderService.update(order);

        return payment;
    }
}
