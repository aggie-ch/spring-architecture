package io.github.aggie.orders;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;

import java.util.Optional;

@RequiredArgsConstructor
public class HibernateOrderRepository implements OrderRepository {

    private final SessionFactory sessionFactory;

    @Override
    public Order save(Order order) {
        var session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(order);
        order.setId(id);
        return order;
    }

    @Override
    public Optional<Order> findById(Long id) {
        var session = sessionFactory.getCurrentSession();
        Order order = session.find(Order.class, id);
        return Optional.ofNullable(order);
    }

    @Override
    public void update(Order order) {
        var session = sessionFactory.getCurrentSession();
        if (session.load(Order.class, order.getId()) != null) {
            session.update(order);
        }
    }
}
