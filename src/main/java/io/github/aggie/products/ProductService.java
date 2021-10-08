package io.github.aggie.products;

import io.github.aggie.common.PagedResult;
import io.github.aggie.common.retry.Retry;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Retry
    public Product add(Product product) {
        throw new RuntimeException();
//        return productRepository.save(product);
    }

    public PagedResult<Product> getAll(int pageNumber, int pageSize) {
        return productRepository.findAll(pageNumber, pageSize);
    }
}
