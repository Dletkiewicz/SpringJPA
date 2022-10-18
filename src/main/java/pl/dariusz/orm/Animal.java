package pl.dariusz.orm;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "animals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private String species;

    public Animal(String name, int age, String species){
        this.name = name;
        this.age = age;
        this.species = species;
    }


}
