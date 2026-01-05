package org.example.care;

import org.example.animals.*;

/**
 * Сервис кормления животных.
 * Принцип SRP: отвечает только за кормление.
 * Принцип DIP: реализует интерфейс AnimalCare.
 */
public class FeedingService implements AnimalCare {
    @Override
    public void provideCare(Animal animal) {
        if (animal instanceof Feedable feedableAnimal) {
            feedableAnimal.feed();
            System.out.println("Сервис кормления: " + animal.getName() + " покормлен");
        } else {
            System.out.println("Сервис кормления: " + animal.getName() +
                    " не может быть покормлен этим сервисом");
        }
    }
    @Override
    public String getCareType() {
        return "Кормление";
    }
}