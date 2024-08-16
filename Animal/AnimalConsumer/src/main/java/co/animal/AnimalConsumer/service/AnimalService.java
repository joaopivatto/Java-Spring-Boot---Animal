package co.animal.AnimalConsumer.service;

import co.animal.AnimalConsumer.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private WebClient webClient;

    private final String uri = "/animal";

    public Animal localizar(int id){
        Mono<Animal> monoAnimal = this.webClient.method(HttpMethod.GET).
                uri(uri + "/" + id).
                retrieve().
                bodyToMono(Animal.class);
        return monoAnimal.block();
    }

    public List<Animal> pesquisar(){
        Mono<List<Animal>> monoListAnimal = this.webClient.method(HttpMethod.GET).
                uri(uri).
                retrieve().
                bodyToFlux(Animal.class).collectList();
        return monoListAnimal.block();
    }

    public Animal salvar(Animal animal){
        Mono<Animal> monoAnimal = this.webClient.method(HttpMethod.POST).
                uri(uri).
                body(BodyInserters.fromValue(animal)).
                retrieve().
                bodyToMono(Animal.class);
        return monoAnimal.block();
    }

    public Void delete(int id){
        Mono<Void> monoVoid = this.webClient.method(HttpMethod.DELETE).
                uri(uri + "/" + id).
                retrieve().
                bodyToMono(Void.class);
        return monoVoid.block();
    }
}
