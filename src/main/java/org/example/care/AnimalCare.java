package org.example.care;

import org.example.animals.Animal;

/**
 * Интерфейс AnimalCare определяет контракт для услуг по уходу за животными.
 * Принцип DIP: модули высокого уровня зависят от абстракций.
 * Все сервисы ухода будут реализовывать этот интерфейс.
 */
public interface AnimalCare {
    void provideCare(Animal animal);
    String getCareType();
}