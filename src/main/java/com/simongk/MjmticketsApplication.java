package com.simongk;

import com.simongk.event.Event;
import com.simongk.event.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MjmticketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MjmticketsApplication.class, args);
	}

	@Bean
	public CommandLineRunner testData(EventRepository repository){
		return e -> {
			repository.save(new Event("Teatro Cubano", "Krakow", "15-05-2017",30,150,"Lorem ipsum dolor mate, a loremnioa asdna dasd"));
			repository.save(new Event("Las Palmas", "Krakow","15-03-2017",40,150,"Lorem ipsum dolor mate, a loremnioa asdna dasd"));
		};
	}
}
