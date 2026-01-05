package org.example.care;

import org.example.animals.*;

/**
 * Сервис кормления животных.
 * Принцип SRP: отвечает только за кормление.
 */
public class FeedingService implements AnimalCare {

    @Override
    public void provideCare(Animal animal) {
        System.out.println("Начинаем кормление: " + animal.getName());

        if (animal instanceof Feedable feedable) {
            System.out.print("Меню: " + feedable.getFoodType());
            System.out.println(", расписание: " + feedable.getFeedingSchedule());
            feedable.feed();
            System.out.println(animal.getName() + " успешно покормлен");
        } else {
            System.out.println(animal.getName() + " не требует кормления");
        }
    }

    @Override
    public String getServiceType() {
        return "Кормление";
    }
}