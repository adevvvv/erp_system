package org.example;

import org.example.animals.*;
import org.example.care.*;

/**
 * Демонстрация всех сервисов ухода.
 * Принцип OCP: добавление новых сервисов без изменений.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ СЕРВИСОВ УХОДА ===");

        // Создание животных
        Animal lion = new Lion("Симба");
        Animal parrot = new Parrot("Кеша");
        Animal snake = new Snake("Каа");

        // Создание всех сервисов
        AnimalCare feedingService = new FeedingService();
        AnimalCare medicalService = new MedicalCheckupService();
        AnimalCare cleaningService = new CleaningService();

        System.out.println("\nСозданы все сервисы:");
        System.out.println("1. " + feedingService.getCareType() + " - кормит животных");
        System.out.println("2. " + medicalService.getCareType() + " - проводит медосмотры");
        System.out.println("3. " + cleaningService.getCareType() + " - убирает вольеры");

        System.out.println("\n--- Работа всех сервисов ---");

        System.out.println("\nКормление всех животных:");
        feedingService.provideCare(lion);
        feedingService.provideCare(parrot);
        feedingService.provideCare(snake);

        System.out.println("\nМедосмотр всех животных:");
        medicalService.provideCare(lion);
        medicalService.provideCare(parrot);
        medicalService.provideCare(snake);

        System.out.println("\nУборка в вольерах:");
        cleaningService.provideCare(lion);
        cleaningService.provideCare(parrot);
    }
}