package com.rbc.shopping.entity;


import lombok.Data;
import javax.persistence.*;

/**
 * Entity class for Users table.
 *
 * @author SARA
 */
@Data
@Entity
@Table(name = "users")
public final class Users {

    @Id
    @GeneratedValue
    private long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="email", nullable = false)
    private String email;

}
