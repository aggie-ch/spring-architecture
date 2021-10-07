package io.github.aggie.payments;

import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    Payment process(PaymentRequest paymentRequest);
}
