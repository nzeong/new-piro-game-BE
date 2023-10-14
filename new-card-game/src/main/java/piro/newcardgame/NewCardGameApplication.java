package piro.newcardgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NewCardGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewCardGameApplication.class, args);
	}

}
