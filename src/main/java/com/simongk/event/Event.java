package com.simongk.event;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by Groobaz on 2017-04-15.
 */

@Entity
@Data
@RequiredArgsConstructor
public class Event {


    //TODO: add sold tickets to db, copy event to past event, create admin mappings
    @Id
    @GeneratedValue
    private Long id;

    //JPA
    public Event() {
    }

    @NonNull
    private String name;
    @NonNull
    private String location;
    @NonNull
    private String date;
    @NonNull
    private int tickets;

    private int soldTickets;

    @NonNull
    private int price;
    @NonNull
    private String description;
}
