package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by ryankielty on 1/21/17.
 */
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    int id;

//    name,email
    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String email;

    public Customer() {

    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
