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

		List<Animal> animals2 = animalRepository.findAll();
		animals2.forEach(System.out::println);

		List<Animal> foundAnimals = animalRepository.findByAge(8);
		foundAnimals.forEach(System.out::println);

		List<Animal> foundAnimals2 = animalRepository.findByName("Kłapouchy");
		foundAnimals.forEach(System.out::println);

		List<Animal> foundAnimals3 = animalRepository.findBySpecies("Lion");
		foundAnimals.forEach(System.out::println);


	}

	private Animal getAnimal() {
		return new Animal("Kłapouchy", 3, "donkey");
	}
}
