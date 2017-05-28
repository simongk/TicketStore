package com.simongk.pastEvent;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Szymon Gasienica-Kotelnicki on 23.05.17.
 */
public interface PastEventRepository extends JpaRepository<PastEvent,Long> {
}
