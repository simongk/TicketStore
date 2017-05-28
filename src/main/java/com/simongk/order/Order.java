package com.simongk.order;

import com.simongk.user.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Szymon Gasienica-Kotelnicki on 21.05.17.
 */
@Entity
@Data
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private int finalCost;

    @ManyToOne
    private User user;
}
