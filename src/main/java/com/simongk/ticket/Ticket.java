package com.simongk.ticket;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by szymon on 14.05.17.
 */
@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue
    private Long id;
    private int quantity;
    private String type;

    public Ticket(String type) {
        this.type = type;
    }
}
