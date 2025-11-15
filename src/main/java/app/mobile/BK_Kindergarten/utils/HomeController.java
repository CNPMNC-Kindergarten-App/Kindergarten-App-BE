package app.mobile.BK_Kindergarten.utils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // This method handles GET requests to the root path ("/") and "/home"
    @GetMapping({"/", "/home"})
    public String home() {
        return "Welcome to the BK Kindergarten Backend API!";
    }
}