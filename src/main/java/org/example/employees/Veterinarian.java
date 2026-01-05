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
        System.out.println("\n" + position + " " + name + " начинает прием:");
        System.out.println("Медицинская услуга: " + service.getServiceType());
        System.out.println("Пациент: " + animal.getName() +
                " (" + animal.getSpecies() + ")");

        service.provideCare(animal);

        System.out.println(position + " " + name + " завершил прием");
    }

    public void makeDiagnosis(Animal animal) {
        System.out.println(position + " " + name + " ставит диагноз " +
                animal.getName());

        if (animal instanceof MedicalCheckable medical) {
            String healthStatus = medical.isHealthy() ? "здоров" : "требует лечения";
            System.out.println("Диагноз: " + animal.getName() + " - " + healthStatus);
        } else {
            System.out.println("Диагноз: " + animal.getName() +
                    " не требует медицинского наблюдения");
        }
    }
}