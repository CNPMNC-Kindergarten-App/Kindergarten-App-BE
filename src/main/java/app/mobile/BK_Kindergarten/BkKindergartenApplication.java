package app.mobile.BK_Kindergarten;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class BkKindergartenApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BkKindergartenApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8080"));
		app.run(args);
	}
}
