package com.codeB.fullstackbackend.repository;

import com.codeB.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// UserRepository extends JpaRepository, providing CRUD operations for the User entity.
public interface UserRepository extends JpaRepository<User, Long> {
    // This interface automatically inherits several methods for handling persistence,
    // including methods for saving, deleting, and finding User entities.

    // By extending JpaRepository, it inherits methods like findAll(), findById(), save(), deleteById(), etc.
    // JpaRepository<User, Long> means it manages User entities with Long type id.
}
