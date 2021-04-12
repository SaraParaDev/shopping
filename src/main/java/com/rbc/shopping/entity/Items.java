package com.rbc.shopping.entity;


import lombok.Data;
import javax.persistence.*;

/**
 * Entity class for ITEMS table.
 *
 * @author SARA
 */
@Data
@Entity
@Table(name = "items")
public final class Items {

    @Id
    @GeneratedValue
    private long id;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="price", nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private ItemCategories itemCategory;
}
