package com.codeB.fullstackbackend.controller;

import com.codeB.fullstackbackend.exception.UserNotFoundException;
import com.codeB.fullstackbackend.model.User;
import com.codeB.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Defines a REST controller that handles HTTP requests.
@RestController
// Enables cross-origin requests from the specified domain.
@CrossOrigin("http://localhost:3000")
public class UserController {

    // Automatically injects the UserRepository instance.
    @Autowired
    private UserRepository userRepository;

    // Handles POST requests to "/user" to create a new user.
    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        // Saves the new user to the repository and returns it.
        return userRepository.save(newUser);
    }

    // Handles GET requests to "/users" to retrieve all users.
    @GetMapping("/users")
    List<User> getAllUsers() {
        // Retrieves all users from the repository and returns them.
        return userRepository.findAll();
    }

    // Handles GET requests to "/user/{id}" to retrieve a user by their ID.
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id) {
        // Retrieves the user by their ID or throws an exception if not found.
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    // Handles PUT requests to "/user/{id}" to update a user by their ID.
    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        // Finds the user by ID, updates their details, and saves them.
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    // Handles DELETE requests to "/user/{id}" to delete a user by their ID.
    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        // Checks if the user exists, throws an exception if not.
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        // Deletes the user by their ID and returns a confirmation message.
        userRepository.deleteById(id);
        return "User with id " + id + " has been deleted successfully.";
    }
}
