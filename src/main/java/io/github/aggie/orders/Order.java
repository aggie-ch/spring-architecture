package io.github.aggie.orders;

import io.github.aggie.payments.LocalMoney;
import io.github.aggie.payments.Payment;
import io.github.aggie.products.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.javamoney.moneta.FastMoney;

import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;
    @NonNull
    private List<Product> products;
    private Payment payment;

    public FastMoney getTotalPrice() {
        return products.stream()
                .map(Product::getPrice)
                .reduce(LocalMoney.zero(), FastMoney::add);
    }
}
