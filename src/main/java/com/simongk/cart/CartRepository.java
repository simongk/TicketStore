package com.simongk.cart;

import com.simongk.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Groobaz on 2017-04-15.
 */
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);
}
