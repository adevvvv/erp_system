package org.example.zoo;

import org.example.animals.Animal;
import java.util.*;

/**
 * Система управления зоопарком.
 * Принцип SRP: отвечает только за управление зоопарком.
 * Принцип DIP: работает с абстракцией Animal.
 */
public class ZooManagementSystem {
    private final String name;
    private final List<Animal> animals;

    public ZooManagementSystem(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public int getAnimalCount() {
        return animals.size();
    }

    public String getName() {
        return name;
    }

}