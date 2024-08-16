package co.animal.AnimalConsumer.controller;

import co.animal.AnimalConsumer.model.Animal;
import co.animal.AnimalConsumer.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/new")
    public String newAnimal(Model model){
        model.addAttribute("animal", new Animal());
        return "animal/form";
    }

    @GetMapping("")
    public String listAnimal(Model model){
        model.addAttribute("listAnimal", animalService.pesquisar());
        return "animal/list";
    }

    @GetMapping("/edit")
    public String editAnimal(@RequestParam("id") int id, Model model){
        model.addAttribute("animal", animalService.localizar(id));
        return "animal/form";
    }

    @PostMapping("/save")
    public String salvarAnimal(@ModelAttribute("animal") Animal animal){
        animalService.salvar(animal);
        return "redirect:/animal";
    }

    @GetMapping("/delete")
    public String excluirAnimal(@RequestParam("id") int id){
        animalService.delete(id);
        return "redirect:/animal";
    }
}
