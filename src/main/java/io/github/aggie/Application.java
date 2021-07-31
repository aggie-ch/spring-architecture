package io.github.aggie;

import io.github.aggie.payments.LocalMoney;
import io.github.aggie.payments.PaymentRequest;
import io.github.aggie.payments.PaymentService;
import lombok.extern.java.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Log
public class Application {

    public static final String BASE_PACKAGE = "io.github.aggie";

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BASE_PACKAGE)) {

            var paymentService = applicationContext.getBean(PaymentService.class);
            var paymentRequest = PaymentRequest.builder()
                    .money(LocalMoney.of(1_000))
                    .build();
            var payment = paymentService.process(paymentRequest);
            log.info(payment.toString());
        }
    }
}
