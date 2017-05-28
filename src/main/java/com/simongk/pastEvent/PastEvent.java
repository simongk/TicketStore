package com.simongk.pastEvent;

import com.simongk.event.Event;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Szymon Gasienica-Kotelnicki on 23.05.17.
 */
@Entity
@Data
public class PastEvent {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date = LocalDate.now();

    private String name;
    private String location;
    private int soldTickets;
    private BigDecimal eventPrice;
    private BigDecimal totalCash;
}
