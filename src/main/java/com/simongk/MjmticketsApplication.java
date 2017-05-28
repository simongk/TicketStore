package com.simongk;

import com.simongk.event.Event;
import com.simongk.event.EventRepository;
import com.simongk.user.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class MjmticketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MjmticketsApplication.class, args);
	}

	@Bean
	public CommandLineRunner testData(EventRepository repository, UserRepository userRepository){
		return e -> {
			repository.save(new Event("Teatro Cubano", "Krakow", "15.05.2016",30,150,"Lorem ipsum dolor mate, a loremnioa asdna dasd"));
			repository.save(new Event("Las Palmas", "Krakow","15.05.2016",40,150,"Lorem ipsum dolor mate, a loremnioa asdna dasd"));
			User user = new User();
			user.setPasswordHash("p");
			user.setEmail("e@e.pl");
			user.setName("u");
			user.setRole(Role.USER);
			user.setCarts(new ArrayList<>());
			userRepository.save(user);

			User user2 = new User();
			user2.setPasswordHash("p1");
			user2.setEmail("e1@e.pl");
			user2.setName("u1");
			user2.setRole(Role.USER);
			user2.setCarts(new ArrayList<>());
			userRepository.save(user2);

		};

	}
}
