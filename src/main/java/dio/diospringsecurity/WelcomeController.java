package dio.diospringsecurity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping
    public String welcome(){
        return "Welcome to My Spring Boot Web Api";
    }
    @GetMapping("/users")
    @PreAuthorize("hasAnyRole('managers','users')")
    public String users(){
        return "Autorized user";
    }
    @GetMapping("/managers")
    @PreAuthorize("hasRole('managers')")
    public String managers(){
        return "Autorized manager";
    }
}