package org.example;

import org.example.animals.*;
import org.example.care.*;
import org.example.employees.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Главный класс для демонстрации работы ERP-системы Московского зоопарка.
 * Демонстрирует применение всех SOLID принципов и принципов ООП.
 * Полная интеграция всех компонентов системы.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("ERP-СИСТЕМА МОСКОВСКОГО ЗООПАРКА");
        System.out.println("=".repeat(60));
        System.out.println("Демонстрация применения SOLID принципов\n");

        Animal lion = new Lion("Симба");
        Animal parrot = new Parrot("Кеша");
        Animal snake = new Snake("Каа");

        List<Animal> allAnimals = new ArrayList<>();
        allAnimals.add(lion);
        allAnimals.add(parrot);
        allAnimals.add(snake);

        System.out.println("Создано животных: " + allAnimals.size());

        AnimalCare feedingService = new FeedingService();
        AnimalCare medicalService = new MedicalCheckupService();
        AnimalCare cleaningService = new CleaningService();

        System.out.println("Созданы сервисы:");
        System.out.println(feedingService.getCareType() + " - кормление");
        System.out.println(medicalService.getCareType() + " - медосмотр");
        System.out.println(cleaningService.getCareType() + " - уборка");

        Employee veterinarian = new Veterinarian("Доктор Айболит");
        Employee zookeeper = new Zookeeper("Иван Петров");
        Employee intern = new Zookeeper("Петя Стажер");

        System.out.println("Созданы сотрудники:");
        System.out.println(veterinarian.getPosition() + " " + veterinarian.getName());
        System.out.println(zookeeper.getPosition() + " " + zookeeper.getName());
        System.out.println(intern.getPosition() + " " + intern.getName());

        System.out.println("\n--- Утренние процедуры ---");

        System.out.println("\nЖивотные просыпаются:");
        for (Animal animal : allAnimals) {
            animal.makeSound();
        }

        System.out.println("\nМЕДОСМОТР:");
        for (Animal animal : allAnimals) {
            veterinarian.performDuty(animal, medicalService);
        }

        System.out.println("\nКОРМЛЕНИЕ:");

        zookeeper.performDuty(lion, feedingService);
        zookeeper.performDuty(parrot, feedingService);
        zookeeper.performDuty(snake, feedingService);

        System.out.println("\nУБОРКА:");
        intern.performDuty(lion, cleaningService);
        intern.performDuty(parrot, cleaningService);
    }
}