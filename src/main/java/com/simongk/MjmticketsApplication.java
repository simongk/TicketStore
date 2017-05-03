package com.simongk;

import com.simongk.event.Event;
import com.simongk.event.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class MjmticketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MjmticketsApplication.class, args);
	}

	@Bean
	public CommandLineRunner testData(EventRepository repository){
		return e -> {
			repository.save(new Event("Teatro Cubano", "Krakow", LocalDate.of(2017,5,15),30,150,"Lorem ipsum dolor mate, a loremnioa asdna dasd"));
			repository.save(new Event("Las Palmas", "Krakow",LocalDate.of(2015,3,3),40,150,"Lorem ipsum dolor mate, a loremnioa asdna dasd"));
		};
	}
}
