package io.github.aggie;

import io.github.aggie.orders.Order;
import io.github.aggie.payments.LocalMoney;
import io.github.aggie.products.Product;
import io.github.aggie.products.ProductType;
import lombok.extern.java.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@Log
public class Application {

    public static final String BASE_PACKAGE = "io.github.aggie";
    public static final Product VIDEO_PRODUCT = Product.builder()
            .name("Mr Robot")
            .description("About developers life")
            .type(ProductType.VIDEO)
            .price(LocalMoney.of(189))
            .build();
    public static final Product BOOK_PRODUCT = Product.builder()
            .name("Java New Edition")
            .description("Developer's book to build microservices")
            .type(ProductType.BOOK)
            .price(LocalMoney.of(49))
            .build();


    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BASE_PACKAGE)) {
            var shopService = applicationContext.getBean(ShopService.class);
            shopService.addProduct(VIDEO_PRODUCT);
            shopService.addProduct(BOOK_PRODUCT);
            log.info(shopService.getProducts(0, 100).toString());

            var order = new Order(List.of(VIDEO_PRODUCT, BOOK_PRODUCT));
            shopService.placeOrder(order);
            var payment = shopService.payForOrder(order.getId());
            log.info(payment.getId());

        }
    }
}
