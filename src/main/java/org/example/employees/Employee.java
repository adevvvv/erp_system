package org.example.employees;

import org.example.animals.*;
import org.example.care.*;

/**
 * Абстрактный класс сотрудника.
 * Принцип DIP: зависит от абстракции AnimalCare.
 * Принцип полиморфизма: общий метод для всех сотрудников.
 */
public abstract class Employee {
    protected String name;
    protected String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void performDuty(Animal animal, AnimalCare service) {
        System.out.println("\n" + position + " " + name + " приступает к работе:");
        System.out.println("Услуга: " + service.getServiceType());
        System.out.println("Животное: " + animal.getName() +
                " (" + animal.getSpecies() + ")");

        service.provideCare(animal);

        System.out.println(position + " " + name + " завершил " +
                service.getServiceType());
    }
}