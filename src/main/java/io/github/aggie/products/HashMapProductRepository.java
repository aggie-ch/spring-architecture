package io.github.aggie.products;

import io.github.aggie.common.PageResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashMapProductRepository implements ProductRepository {

    private Map<Long, Product> products = new HashMap<>();
    private long index = 0;


    @Override
    public Product save(Product product) {
        product.setId(++index);
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public PageResult<Product> findAll(int pageNumber, int pageSize) {

        var totalPages = (int) Math.ceil((double) products.size() / pageSize);
        var data = new ArrayList<>(products.values());

        return new PageResult(data, pageNumber, totalPages);
    }
}
