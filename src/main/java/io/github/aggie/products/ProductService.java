package io.github.aggie.products;

import io.github.aggie.common.PageResult;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product add(Product product) {
        return productRepository.save(product);
    }

    public PageResult<Product> getAll(int pageNumber, int pageSize) {
        return productRepository.findAll(pageNumber, pageSize);
    }
}
