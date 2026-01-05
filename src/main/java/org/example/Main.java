package org.example;

import org.example.animals.*;
import org.example.care.*;

/**
 * Демонстрация сервисов ухода.
 * Принцип SRP: каждый сервис имеет одну ответственность.
 * Принцип DIP: сервисы реализуют интерфейс AnimalCare.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== СОЗДАНИЕ СЕРВИСОВ УХОДА ===");

        // Создание животных
        Animal lion = new Lion("Симба");
        Animal parrot = new Parrot("Кеша");

        // Создание сервисов
        AnimalCare feedingService = new FeedingService();
        AnimalCare medicalService = new MedicalCheckupService();

        System.out.println("\nСозданы сервисы:");
        System.out.println("1. FeedingService - сервис кормления");
        System.out.println("   Тип ухода: " + feedingService.getCareType());

        System.out.println("\n2. MedicalCheckupService - сервис медосмотров");
        System.out.println("   Тип ухода: " + medicalService.getCareType());

        System.out.println("\n--- Демонстрация работы сервисов ---");

        System.out.println("\nКормление льва:");
        feedingService.provideCare(lion);

        System.out.println("\nМедосмотр попугая:");
        medicalService.provideCare(parrot);

    }
}