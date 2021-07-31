package io.github.aggie.payments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class HashMapRepositoryPaymentTest {

    public static final String PAYMENT_ID = "1";
    public static final Payment PAYMENT = Payment.builder()
            .id(PAYMENT_ID)
            .build();

    private final HashMapPaymentRepository paymentRepository = new HashMapPaymentRepository();

    @Mock
    private Map<String, Payment> payments;


    @BeforeEach
    void setUp() {
        paymentRepository.setPayments(payments);

    }


    @DisplayName("Should add payment to hashMap under payment id key")
    @Test
    void shouldAddPaymentToHashMapUnderPaymentId() {

        paymentRepository.save(PAYMENT);
        verify(payments).put(PAYMENT_ID, PAYMENT);
    }
}
