package com.rbc.shopping.entity;


import lombok.Data;

import javax.persistence.*;

/**
 * Entity class for WISH table.
 *
 * @author SARA
 */
@Data
@Entity
@Table(name = "wish")
public final class Wish {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", insertable = false, updatable = false)
    private Items item;

}
