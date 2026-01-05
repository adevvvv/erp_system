package org.example.animals;

/**
 * Абстрактный класс AbstractAnimal предоставляет базовую реализацию для животных.
 * Принцип LSP: может быть заменен любым наследником без изменения поведения.
 * Содержит общую логику для всех животных.
 */
public abstract class AbstractAnimal implements Animal {
    /**
     * Принцип инкапсуляции: protected для доступа в наследниках.
     */
    protected String name;
    protected String species;
    protected String sound;
    public AbstractAnimal(String name, String species, String sound) {
        this.name = name;
        this.species = species;
        this.sound = sound;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getSpecies() {
        return species;
    }

    /**
     * Издать характерный звук животного.
     * Принцип полиморфизма: реализация может быть переопределена.
     */
    @Override
    public void makeSound() {
        System.out.println(name + " издает звук: " + sound);
    }
}