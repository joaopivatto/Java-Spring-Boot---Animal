package br.com.joaopivatto.apianimal.service;

import br.com.joaopivatto.apianimal.model.Animal;
import br.com.joaopivatto.apianimal.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public Animal localiza(int id){
        Optional<Animal> animal = animalRepository.findById(id);
        return animal.orElse(null);
    }

    public List<Animal> pesquisa(){
        return animalRepository.findAll();
    }

    public Animal salvar(Animal animal){
        return animalRepository.save(animal);
    }

    public void excluir(int id){
        animalRepository.deleteById(id);
    }
}
