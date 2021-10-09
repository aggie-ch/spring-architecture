package io.github.aggie.products;

import io.github.aggie.common.PagedResult;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import java.util.*;


@RequiredArgsConstructor
public class HibernateProductRepository implements ProductRepository {

    private final SessionFactory sessionFactory;

    @Override
    public Product save(Product product) {
        var session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(product);
        product.setId(id);
        return product;
    }

    @Override
    public PagedResult<Product> findAll(int pageNumber, int pageSize) {
        List<Product> products = sessionFactory.getCurrentSession()
                .createNamedQuery(Product.SELECT_PRODUCTS, Product.class)
                .setFirstResult(pageNumber * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
        return new PagedResult<>(products, pageNumber, -1);
    }
}
