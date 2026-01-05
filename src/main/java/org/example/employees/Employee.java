package org.example.employees;

import org.example.animals.*;
import org.example.care.*;


/**
 * Абстрактный класс сотрудника.
 * Принцип DIP: зависит от абстракции AnimalCare.
 * Принцип полиморфизма: абстрактный метод для разных реализаций.
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

    /**
     * Выполнить обязанность.
     * Принцип полиморфизма: абстрактный метод для разных реализаций.
     */
    public abstract void performDuty(Animal animal, AnimalCare service);
}