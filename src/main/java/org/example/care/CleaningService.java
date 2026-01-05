package org.example.care;

import org.example.animals.Animal;

/**
 * Сервис уборки вольеров.
 * Принцип OCP: можно добавлять новые сервисы без изменения существующих.
 * Принцип DIP: реализует интерфейс AnimalCare.
 */
public class CleaningService implements AnimalCare {
    @Override
    public void provideCare(Animal animal) {
        System.out.println("Сервис уборки: убрано в вольере " + animal.getName());
    }
    @Override
    public String getCareType() {
        return "Уборка";
    }
}