package es.avoris.boats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AvorisbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvorisbackApplication.class, args);
	}

}
