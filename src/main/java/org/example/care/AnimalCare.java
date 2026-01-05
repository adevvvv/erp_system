package org.example.care;

import org.example.animals.Animal;

/**
 * Интерфейс услуг по уходу за животными.
 * Принцип DIP: модули высокого уровня зависят от абстракций.
 * Принцип ISP: общий интерфейс для всех услуг.
 */
public interface AnimalCare {
    void provideCare(Animal animal);
    String getServiceType();
}