package io.aiven.spring.mysql.sqlintegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping(path = "/crudProject")
public class MainController {



    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity<?> addNewUser(@RequestParam String name, @RequestParam String email) {
        // Check if the user already exists by email
        User existingUser = userRepository.findByEmail(email);

        if (existingUser != null) {
            // Return a response indicating the user already exists
            return ResponseEntity.status(409)
                    .body("User with  " + email + " already exists.");
        }

        // Create and save the new user
        User springUser = new User();
        springUser.setEmail(email);
        springUser.setName(name);
        userRepository.save(springUser);

        // Return the newly created user
        return ResponseEntity.status(HttpStatus.CREATED).body(springUser);
    }


    @GetMapping(path = "/all")
    public @ResponseBody Iterable<?> getAllUsers(){
        return userRepository.findAll();
    }




}
