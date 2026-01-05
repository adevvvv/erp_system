package org.example.enclosures;

import java.util.ArrayList;
import java.util.List;
import org.example.animals.*;

/**
 * Класс вольера для содержания животных.
 * Принцип SRP: отвечает только за управление вольером.
 * Принцип композиции: содержит коллекцию животных.
 */
public class Enclosure {
    private final String name;
    private final List<Animal> animals;
    public Enclosure(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }
    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.getName() + " добавлен в вольер \"" + name + "\"");
    }

    public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }
    public String getName() {
        return name;
    }
    public int getAnimalCount() {
        return animals.size();
    }
    public boolean isEmpty() {
        return animals.isEmpty();
    }

}