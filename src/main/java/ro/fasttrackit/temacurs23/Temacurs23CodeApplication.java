package ro.fasttrackit.temacurs23;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.temacurs23.model.DailyFoodPlanner;
import ro.fasttrackit.temacurs23.repository.DailyFoodPlannerRepository;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Temacurs23CodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Temacurs23CodeApplication.class, args);
	}
	@Bean
	CommandLineRunner atStartUp(DailyFoodPlannerRepository repository){
		return args -> {
			repository.saveAll(List.of(
					new DailyFoodPlanner(List.of("Lapte","Cereale","Orez cu legume","Gris cu lapte")),
					new DailyFoodPlanner(List.of("Oua fierte cu avocado","Mazare cu carne","Clatite americane cu unt de arahide")),
					new DailyFoodPlanner(List.of("Terci de ovaz","Tocanita de cartofi","Fructe")),
					new DailyFoodPlanner(List.of("Paine cu ou","Dovlecel pane cu pilaf de orez","Chec cu lapte")),
					new DailyFoodPlanner(List.of("Budinca de chia","Linte cu soia","Prajitura cu mere")),
					new DailyFoodPlanner(List.of("Omleta","Placinta cu branza","Mamaliga cu lapte")),
					new DailyFoodPlanner(List.of("Ochiuri de oua cu bacon","Cartofi si carne la cuptor","Prajitura cu nuca"))
					));
		};
	}

}
