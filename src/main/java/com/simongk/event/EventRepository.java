package com.simongk.event;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Groobaz on 2017-04-15.
 */
public interface EventRepository extends JpaRepository<Event, Long> {
    Event findByName(String name);
}
