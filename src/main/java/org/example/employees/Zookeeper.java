package org.example.employees;

import org.example.animals.*;
import org.example.care.*;

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
        System.out.println("\n" + position + " " + name + " приступает к работе:");
        System.out.println("Выполняемая услуга: " + service.getCareType());
        System.out.println("Животное: " + animal.getName() + " (" + animal.getSpecies() + ")");

        service.provideCare(animal);

        System.out.println(position + " " + name + " завершил " + service.getCareType());
    }
    public String getResponsibilityZone() {
        return "Все вольеры";
    }
}