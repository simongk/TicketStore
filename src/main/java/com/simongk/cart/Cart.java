package com.simongk.cart;

import com.simongk.event.Event;
import com.simongk.ticket.Ticket;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

    public Cart(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @OneToMany
    private List<Ticket> tickets;

    @OneToOne
    private Event event;
}
