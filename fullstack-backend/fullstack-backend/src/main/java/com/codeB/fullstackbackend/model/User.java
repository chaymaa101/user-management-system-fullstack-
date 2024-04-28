package com.codeB.fullstackbackend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// Entity annotation marks this class as a JPA entity (i.e., a persisted data class)
@Entity
public class User {

    // Id annotation marks this field as the primary key
    @Id
    // GeneratedValue annotation specifies that the ID should be generated automatically
    @GeneratedValue
    private Long id;
    private String username;
    private String name;
    private String email;

    // Getter for the user ID
    public Long getId() {
        return id;
    }

    // Setter for the user ID
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for the username
    public String getUsername() {
        return username;
    }

    // Setter for the username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for the user's full name
    public String getName() {
        return name;
    }

    // Setter for the user's full name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the user's email address
    public String getEmail() {
        return email;
    }

    // Setter for the user's email address
    public void setEmail(String email) {
        this.email = email;
    }
}
