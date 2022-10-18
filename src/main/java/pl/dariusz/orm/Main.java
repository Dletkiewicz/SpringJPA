package pl.dariusz.orm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

	@Autowired
	AnimalRepository animalRepository;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Animal> animals = animalRepository.findAll();
		animals.forEach(System.out::println);

		Animal someAnimal = getAnimal();

		animalRepository.save(someAnimal);

		List<Animal> users2 = animalRepository.findAll();
		users2.forEach(System.out::println);
	}

	private Animal getAnimal() {
		return new Animal("Puszek", 8, "Lion");
	}
}
