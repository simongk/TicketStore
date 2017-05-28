package com.simongk.cart;

import com.simongk.event.Event;
import com.simongk.user.User;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by Groobaz on 2017-04-15.
 */
@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue
    private Long id;
    private int ticketQuantity;
    private int totalCost;
    private String ticketType;
    private String discountCode;

    @ManyToOne
    private User user;

    @OneToOne
    private Event event;
}
