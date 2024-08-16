package br.com.joaopivatto.apianimal.controller;

import br.com.joaopivatto.apianimal.model.Animal;
import br.com.joaopivatto.apianimal.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping("/{id}")
    public ResponseEntity<Animal> findById(@PathVariable int id){
        return ResponseEntity.ok(animalService.localiza(id));
    }

    @GetMapping()
    public ResponseEntity<List<Animal>> findAll(){
        return ResponseEntity.ok(animalService.pesquisa());
    }

    @PostMapping()
    public ResponseEntity<Animal> save(@RequestBody Animal animal){
        return ResponseEntity.ok(animalService.salvar(animal));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        animalService.excluir(id);
    }
}
