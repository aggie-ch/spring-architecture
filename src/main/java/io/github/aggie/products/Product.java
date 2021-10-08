package io.github.aggie.products;

import lombok.*;
import org.hibernate.annotations.Columns;
import org.javamoney.moneta.FastMoney;

import javax.persistence.*;

@Table(name = "products", indexes = @Index(name = "product_type", columnList = "type"))
@Entity
@Builder
@Data
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private String description;
    @Columns(columns = {
            @Column(name = "currency", length = 3),
            @Column(name = "value")
    })
    private FastMoney price;
    @Enumerated(EnumType.STRING)
    private ProductType type;
}
