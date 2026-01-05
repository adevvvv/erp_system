package org.example.employees;

import org.example.animals.*;
import org.example.care.*;
import org.example.enclosures.Enclosure;

/**
 * Класс смотрителя зоопарка.
 * Принцип OCP: можно добавлять новые типы сотрудников.
 * Принцип LSP: может заменить Employee.
 */
public class Zookeeper extends Employee {

    public Zookeeper(String name) {
        super(name, "Смотритель зоопарка");
    }

    @Override
    public void performDuty(Animal animal, AnimalCare service) {
        System.out.println("\n" + position + " " + name + " выполняет работу:");
        System.out.println("Услуга: " + service.getServiceType());
        System.out.println("Подопечный: " + animal.getName() +
                " (" + animal.getSpecies() + ")");

        service.provideCare(animal);

        System.out.println(position + " " + name + " завершил работу");
    }
    public void cleanEnclosure(Enclosure enclosure) {
        System.out.println(position + " " + name +
                " убирает вольер: " + enclosure.getName());
        System.out.println("В вольере животных: " + enclosure.getAnimalCount());
        System.out.println("Вольер " + enclosure.getName() + " убран");
    }

}