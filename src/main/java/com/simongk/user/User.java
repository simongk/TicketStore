package com.simongk.user;

import com.simongk.cart.Cart;
import com.simongk.order.Order;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Szymon Gasienica-Kotelnicki on 21.05.17.
 */

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String passwordHash;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany
    private List<Cart> carts;

    @OneToMany
    private List<Order> orders;

    public User(String name) {
        this.name = name;
    }
}

