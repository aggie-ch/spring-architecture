package io.github.aggie.products;

import io.github.aggie.common.PageResult;

public interface ProductRepository {

    Product save(Product product);

    PageResult<Product> findAll(int pageNumber, int pageSize);
}
