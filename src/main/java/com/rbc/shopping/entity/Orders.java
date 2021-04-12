package com.rbc.shopping.entity;


import lombok.Data;

import java.util.Date;
import javax.persistence.*;
import java.util.Date;

/**
 * Entity class for ORDERS table.
 *
 * @author SARA
 */
@Data
@Entity
@Table(name = "orders")
public final class Orders {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "quantity", nullable = false)
    private String quantity;

    @Column(name = "user_rating", nullable = false)
    private long user_rating;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created")
    private Date date_created;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "item_id", insertable = false, updatable = false)
    private Items item;
}
