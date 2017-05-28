package com.simongk.order;

import com.simongk.cart.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Szymon Gasienica-Kotelnicki on 21.05.17.
 */
@Service
public class OrderService {

    public int calculateOrderPrice(List<Cart> cartList){
        return cartList.stream()
                .map(Cart::getTotalCost)
                .reduce(0,(a,b) -> a+b);
    }

}
