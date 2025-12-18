package org.example.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UserManagementApplication {

    void main() { SpringApplication.run(UserManagementApplication.class);
    }

    @GetMapping("/")
    public String hello(){
        return "Hello word";
    }

}
