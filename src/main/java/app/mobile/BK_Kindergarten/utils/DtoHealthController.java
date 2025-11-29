package app.mobile.BK_Kindergarten.utils;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class DtoHealthController {
    @GetMapping({"/api/health"})
    public Map<String, String> home() {
        // Spring Boot automatically converts this Map into a JSON object.
        return Collections.singletonMap("status", "OK");
    }
}