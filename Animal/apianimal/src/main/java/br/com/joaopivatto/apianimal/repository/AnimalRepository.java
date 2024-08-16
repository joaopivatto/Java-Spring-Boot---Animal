package br.com.joaopivatto.apianimal.repository;

import br.com.joaopivatto.apianimal.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
