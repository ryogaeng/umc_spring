package umc.week9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Week9Application {

	public static void main(String[] args) {
		SpringApplication.run(Week9Application.class, args);
	}

}
