package org.example.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UserManagementApplication {

    static void main(String[] args) { SpringApplication.run(UserManagementApplication.class, args);
    }

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/verificar")
    public String verificarHilo() {
        return Thread.currentThread().toString();
    }

}
