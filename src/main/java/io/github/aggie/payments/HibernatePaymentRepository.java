package io.github.aggie.payments;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;

@RequiredArgsConstructor
public class HibernatePaymentRepository implements PaymentRepository {

    private final SessionFactory sessionFactory;

    @Override
    public Payment save(Payment payment) {
        var session = sessionFactory.getCurrentSession();
        String id = (String) session.save(payment);
        payment.setId(id);
        return payment;
    }
}
