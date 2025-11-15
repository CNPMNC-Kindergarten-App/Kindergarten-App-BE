package app.mobile.BK_Kindergarten;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")  // Use test profile
class BkKindergartenApplicationTests {

	@Test
	void contextLoads() {
		// This test will use H2 database
	}
}