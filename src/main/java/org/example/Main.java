package org.example;

import org.example.animals.*;
import org.example.care.*;
import org.example.employees.*;
import org.example.enclosures.*;
import org.example.report.*;
import org.example.zoo.*;
import org.example.exhibitions.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ERP-СИСТЕМА МОСКОВСКОГО ЗООПАРКА ===");
        System.out.println("Демонстрация применения SOLID принципов\n");

        ZooManagementSystem zoo = new ZooManagementSystem("Московский зоопарк");

        System.out.println("1. СОЗДАНИЕ ЖИВОТНЫХ:");
        System.out.println("-".repeat(40));

        Lion lion = new Lion("Симба");
        Parrot parrot = new Parrot("Кеша");
        Snake snake = new Snake("Каа");
        RobotAnimal robot = new RobotAnimal("Робо-Пёс");
        Lion lion2 = new Lion("Муфаса");

        List<Animal> animals = Arrays.asList(lion, parrot, snake, robot, lion2);

        for (Animal animal : animals) {
            zoo.addAnimal(animal);
            System.out.println("Добавлено: " + animal.getName() +
                    " (" + animal.getSpecies() + ")");
        }
        System.out.println("Всего животных: " + zoo.getAnimalCount());

        System.out.println("\n2. СОЗДАНИЕ ВОЛЬЕРОВ:");
        System.out.println("-".repeat(40));

        Enclosure bigCatsEnclosure = new Enclosure("Вольер для больших кошек");
        Enclosure birdsEnclosure = new Enclosure("Вольер для птиц");
        Enclosure reptilesEnclosure = new Enclosure("Террариум для рептилий");
        Enclosure robotsEnclosure = new Enclosure("Павильон роботов");

        bigCatsEnclosure.addAnimal(lion);
        bigCatsEnclosure.addAnimal(lion2);
        birdsEnclosure.addAnimal(parrot);
        reptilesEnclosure.addAnimal(snake);
        robotsEnclosure.addAnimal(robot);

        System.out.println("Создано 4 вольера с животными");

        System.out.println("\n3. НАЙМ СОТРУДНИКОВ:");
        System.out.println("-".repeat(40));

        Zookeeper zookeeper = new Zookeeper("Иван Петров");
        Veterinarian veterinarian = new Veterinarian("Анна Сидорова");
        Employee exhibitionManager = new Zookeeper("Сергей Иванов");

        System.out.println("Наняты: " + zookeeper.getName() + " - " + zookeeper.getPosition());
        System.out.println("Наняты: " + veterinarian.getName() + " - " + veterinarian.getPosition());
        System.out.println("Наняты: " + exhibitionManager.getName() + " - Выставочный менеджер");

        System.out.println("\n4. СОЗДАНИЕ СЕРВИСОВ:");
        System.out.println("-".repeat(40));

        AnimalCare feedingService = new FeedingService();
        AnimalCare medicalService = new MedicalService();
        AnimalCare cleaningService = new CleaningService();
        AnimalCare admissionService = new AdmissionMedicalService();
        AnimalCare exhibitionService = new ExhibitionService("Ежегодная выставка животных");

        System.out.println("Создано 5 сервисов ухода за животными");

        System.out.println("\n5. МЕДИЦИНСКИЙ ОСМОТР ПРИ ПРИЕМЕ:");
        System.out.println("-".repeat(40));

        System.out.println("Все новые животные проходят обязательный медосмотр:");
        for (Animal animal : animals) {
            admissionService.provideCare(animal);
        }

        System.out.println("\n6. ОРГАНИЗАЦИЯ ВЫСТАВКИ:");
        System.out.println("-".repeat(40));

        Exhibition animalExhibition = new Exhibition("Ежегодная выставка животных",
                "Демонстрация самых интересных обитателей зоопарка");

        System.out.println("Отбор участников выставки:");
        for (Animal animal : animals) {
            if (animal instanceof Exhibitable) {
                animalExhibition.addParticipant(animal);
            }
        }

        System.out.println("Отобрано участников: " + animalExhibition.getParticipantCount());

        System.out.println("\nУТРО: КОРМЛЕНИЕ ЖИВОТНЫХ");
        System.out.println("-".repeat(30));

        for (Animal animal : animals) {
            if (animal instanceof Feedable) {
                zookeeper.performDuty(animal, feedingService);
            } else {
                System.out.println(animal.getName() + " (" + animal.getSpecies() +
                        ") не требует кормления");
            }
        }

        System.out.println("\nДЕНЬ: ПОДГОТОВКА К ВЫСТАВКЕ");
        System.out.println("-".repeat(30));

        exhibitionManager.performDuty(lion, exhibitionService);
        exhibitionManager.performDuty(parrot, exhibitionService);

        animalExhibition.startExhibition();

        System.out.println("\nВЕЧЕР: ПЛАНОВЫЕ МЕДИЦИНСКИЕ ОСМОТРЫ");
        System.out.println("-".repeat(30));

        for (Animal animal : animals) {
            if (animal instanceof MedicalCheckable) {
                veterinarian.performDuty(animal, medicalService);
            } else {
                System.out.println(animal.getName() + " (" + animal.getSpecies() +
                        ") не требует медосмотра");
            }
        }

        System.out.println("\nНОЧЬ: УБОРКА ВОЛЬЕРОВ");
        System.out.println("-".repeat(30));

        for (Animal animal : animals) {
            zookeeper.performDuty(animal, cleaningService);
        }

        System.out.println("\nСПЕЦИАЛЬНЫЕ ОБЯЗАННОСТИ:");
        System.out.println("-".repeat(30));

        zookeeper.cleanEnclosure(bigCatsEnclosure);
        zookeeper.cleanEnclosure(birdsEnclosure);

        for (Animal animal : animals) {
            if (animal instanceof MedicalCheckable) {
                veterinarian.makeDiagnosis(animal);
            }
        }

        System.out.println("\n8. ОТЧЕТНОСТЬ:");
        System.out.println("-".repeat(40));

        ReportModule reportModule = new ReportModule();

        System.out.println("\nЕЖЕДНЕВНЫЙ ОТЧЕТ:");
        System.out.println("-".repeat(30));
        reportModule.generateAnimalReport(animals);

        System.out.println("\nРАСПИСАНИЕ КОРМЛЕНИЯ:");
        System.out.println("-".repeat(30));
        reportModule.generateFeedingSchedule(animals);

        System.out.println("\nМЕДИЦИНСКИЙ ОТЧЕТ:");
        System.out.println("-".repeat(30));
        reportModule.generateMedicalReport(animals);

        System.out.println("\nОТЧЕТ ПО ВОЛЬЕРАМ:");
        System.out.println("-".repeat(30));
        List<Enclosure> enclosures = Arrays.asList(
                bigCatsEnclosure, birdsEnclosure, reptilesEnclosure, robotsEnclosure
        );
        for (Enclosure enclosure : enclosures) {
            reportModule.generateEnclosureReport(enclosure);
        }
    }
}