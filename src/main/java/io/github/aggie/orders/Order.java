package io.github.aggie.orders;

import io.github.aggie.payments.LocalMoney;
import io.github.aggie.payments.Payment;
import io.github.aggie.products.Product;
import lombok.*;
import org.javamoney.moneta.FastMoney;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.List;

@Table(name = "orders")
@Entity
@Data
@EqualsAndHashCode(exclude = "id")
@RequiredArgsConstructor
@NoArgsConstructor
public class Order {

    @GeneratedValue
    @Id
    private Long id;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @NotEmpty
    @NonNull
    private List<Product> products;
    @OneToOne(cascade = CascadeType.PERSIST)
    @Valid
    private Payment payment;
    private Instant timestamp;

    public FastMoney getTotalPrice() {
        return products.stream()
                .map(Product::getPrice)
                .reduce(LocalMoney.zero(), FastMoney::add);
    }
}
