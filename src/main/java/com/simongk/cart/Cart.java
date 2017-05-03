package com.simongk.cart;

import com.simongk.event.Event;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

    @OneToOne
    private Event event;
}
