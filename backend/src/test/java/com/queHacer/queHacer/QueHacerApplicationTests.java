package com.queHacer.queHacer;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(properties = {
		"DATABASE_URL=${DATABASE_URL}",
		"DATABASE_USER=${DATABASE_USER}",
		"DATABASE_PASSWORD=${DATABASE_PASSWORD}"
})
class QueHacerApplicationTests {

	@Test
	void contextLoads() {
	}

}
