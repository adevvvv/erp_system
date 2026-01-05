package org.example;

/**
 * Демонстрация работы с животными.
 * Принцип OCP: добавление нового вида без изменений.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ С ЖИВОТНЫМИ ===");

        // Создание животных
        Animal lion = new Lion("Симба");
        Animal parrot = new Parrot("Кеша");
        Animal snake = new Snake("Каа");

        System.out.println("\nСозданы животные:");
        System.out.println("- " + lion.getName() + " (" + lion.getSpecies() + ")");
        System.out.println("- " + parrot.getName() + " (" + parrot.getSpecies() + ")");
        System.out.println("- " + snake.getName() + " (" + snake.getSpecies() + ")");

        System.out.println("\n--- Поведение животных ---");
        lion.makeSound();
        parrot.makeSound();
        snake.makeSound();

        System.out.println("\n--- Кормление ---");
        ((Feedable) lion).feed();
        System.out.println("Расписание: " + ((Feedable) lion).getFeedingSchedule());
        System.out.println("Тип еды: " + ((Feedable) lion).getFoodType());

        System.out.println("\n--- Медицинский осмотр ---");
        ((MedicalCheckable) parrot).performMedicalCheckup();
        System.out.println("Состояние здоровья: " +
                (((MedicalCheckable) parrot).isHealthy() ? "Здоров" : "Требует внимания"));

        System.out.println("\n--- Демонстрация Snake ---");
        ((Feedable) snake).feed();
        System.out.println("Особенность: " + ((Feedable) snake).getFeedingSchedule());
    }
}