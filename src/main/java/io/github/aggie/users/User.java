package io.github.aggie.users;

import io.github.aggie.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Table(name = "users", indexes = @Index(name = "email", columnList = "email"))
@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
}
