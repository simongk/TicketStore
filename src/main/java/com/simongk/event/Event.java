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
    private LocalDate date;
    @NonNull
    private int tickets;
    @NonNull
    private int price;
    @NonNull
    private String description;
}
