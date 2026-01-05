package org.example.employees;

import org.example.animals.*;
import org.example.care.*;

/**
 * Класс ветеринара.
 * Принцип LSP: может заменить Employee.
 * Принцип DIP: зависит от AnimalCare, а не от конкретных сервисов.
 */
public class Veterinarian extends Employee {
    public Veterinarian(String name) {
        super(name, "Ветеринар");
    }
    @Override
    public void performDuty(Animal animal, AnimalCare service) {
        System.out.println("\n" + position + " " + name + " приступает к работе:");
        System.out.println("Выполняемая услуга: " + service.getCareType());
        System.out.println("Пациент: " + animal.getName() + " (" + animal.getSpecies() + ")");

        service.provideCare(animal);

        System.out.println(position + " " + name + " завершил " + service.getCareType());
    }
    public String getSpecialization() {
        return "Общая ветеринария";
    }
}