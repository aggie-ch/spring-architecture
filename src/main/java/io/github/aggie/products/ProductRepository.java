package io.github.aggie.products;

import io.github.aggie.common.PagedResult;

public interface ProductRepository {

    Product save(Product product);

    PagedResult<Product> findAll(int pageNumber, int pageSize);
}
