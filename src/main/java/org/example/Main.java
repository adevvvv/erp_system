package org.example;

import org.example.animals.*;
import org.example.care.*;
import org.example.employees.*;
/**
 * Демонстрация классов сотрудников.
 * Принцип DIP: сотрудники зависят от абстракций.
 * Принцип LSP: наследники заменяют родительский класс.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== СОЗДАНИЕ КЛАССОВ СОТРУДНИКОВ ===");

        // Создание животных и сервисов
        Animal lion = new Lion("Симба");
        Animal parrot = new Parrot("Кеша");

        AnimalCare feedingService = new FeedingService();
        AnimalCare medicalService = new MedicalCheckupService();
        AnimalCare cleaningService = new CleaningService();

        // Создание сотрудников
        Veterinarian veterinarian = new Veterinarian("Доктор Айболит");
        Zookeeper zookeeper = new Zookeeper("Иван Петров");

        System.out.println("\nСозданы сотрудники:");
        System.out.println("1. " + veterinarian.getPosition() + " " + veterinarian.getName());
        System.out.println("   - Специализация: " + veterinarian.getSpecialization());

        System.out.println("\n2. " + zookeeper.getPosition() + " " + zookeeper.getName());
        System.out.println("   - Зона ответственности: " + zookeeper.getResponsibilityZone());

        System.out.println("\n--- Работа сотрудников ---");

        System.out.println("\n1. Ветеринар проводит медосмотр:");
        veterinarian.performDuty(lion, medicalService);

        System.out.println("\n2. Ветеринар кормит животное:");
        veterinarian.performDuty(parrot, feedingService);

        System.out.println("\n3. Смотритель кормит животное:");
        zookeeper.performDuty(lion, feedingService);

        System.out.println("\n4. Смотритель убирает вольер:");
        zookeeper.performDuty(parrot, cleaningService);

        System.out.println("Можем работать с сотрудниками через родительский класс:");

        Employee[] employees = { veterinarian, zookeeper };
        for (Employee emp : employees) {
            System.out.println("\n" + emp.getPosition() + " " + emp.getName() + " работает:");
            emp.performDuty(lion, medicalService);
        }
    }
}