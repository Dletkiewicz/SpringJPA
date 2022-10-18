package pl.dariusz.orm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByName(String name);
    List<Animal> findByAge(int age);
    List<Animal> findBySpecies(String species);

}
