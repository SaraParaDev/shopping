package com.rbc.shopping.entity;


import lombok.Data;
import javax.persistence.*;

/**
 * Entity class for ITEM_CATEGORIES table.
 *
 * @author SARA
 */
@Data
@Entity
@Table(name = "items_categories")
public final class ItemCategories {

    @Id
    @GeneratedValue
    private long id;

    @Column(name="description", nullable = false)
    private String description;

}
