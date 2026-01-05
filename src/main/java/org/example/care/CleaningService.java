package org.example.care;

import org.example.animals.Animal;

/**
 * Сервис уборки.
 * Принцип OCP: можно добавлять новые сервисы.
 */
public class CleaningService implements AnimalCare {

    @Override
    public void provideCare(Animal animal) {
        System.out.println("Уборка территории для: " + animal.getName());
        System.out.println("Чистим вольер, меняем воду, убираем отходы");
        System.out.println("Территория " + animal.getName() + " убрана");
    }

    @Override
    public String getServiceType() {
        return "Уборка";
    }
}