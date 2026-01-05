package org.example.report;

import org.example.animals.*;
import org.example.enclosures.Enclosure;
import java.util.List;

/**
 * Модуль отчетности.
 * Принцип SRP: отвечает только за генерацию отчетов.
 */
public class ReportModule {

    public void generateAnimalReport(List<Animal> animals) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("КРАТКАЯ СВОДКА ПО ЖИВОТНЫМ");
        System.out.println("=".repeat(60));

        int total = animals.size();
        int needFeeding = 0;
        int needMedical = 0;

        System.out.println("\nИмя животного Вид Кормление Медосмотр");
        System.out.println("-".repeat(60));

        for (Animal animal : animals) {
            String feedingStatus = (animal instanceof Feedable) ? "Требуется" : "Не требуется";
            String medicalStatus = (animal instanceof MedicalCheckable) ? "Требуется" : "Не требуется";

            if (animal instanceof Feedable) needFeeding++;
            if (animal instanceof MedicalCheckable) needMedical++;

            System.out.printf("%-20s %-15s %-12s %-12s%n",
                    animal.getName(),
                    animal.getSpecies(),
                    feedingStatus,
                    medicalStatus);
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.println("СТАТИСТИКА:");
        System.out.println("Всего животных: " + total);
        System.out.println("Требуют кормления: " + needFeeding);
        System.out.println("Требуют медосмотра: " + needMedical);
        System.out.println("=".repeat(60));
    }

    public void generateFeedingSchedule(List<Animal> animals) {
        System.out.println("\nРАСПИСАНИЕ КОРМЛЕНИЯ:");
        System.out.println("-".repeat(40));

        for (Animal animal : animals) {
            if (animal instanceof Feedable feedable) {
                System.out.println(animal.getName() + " (" + animal.getSpecies() + "):");
                System.out.println("  • Расписание: " + feedable.getFeedingSchedule());
                System.out.println("  • Тип еды: " + feedable.getFoodType());
                System.out.println();
            }
        }
    }

    public void generateMedicalReport(List<Animal> animals) {
        System.out.println("\nМЕДИЦИНСКИЙ ОТЧЕТ:");
        System.out.println("-".repeat(40));

        int healthy = 0;
        int totalMedical = 0;

        for (Animal animal : animals) {
            if (animal instanceof MedicalCheckable medical) {
                totalMedical++;
                if (medical.isHealthy()) healthy++;

                System.out.println(animal.getName() + " (" + animal.getSpecies() + "):");
                System.out.println("  • Состояние: " +
                        (medical.isHealthy() ? "Здоров" : "Требует лечения"));
                System.out.println("  • Последняя запись: " + medical.getMedicalRecord());
                System.out.println();
            }
        }

        System.out.println("СТАТИСТИКА: " + healthy + "/" + totalMedical + " здоровых");
    }

    public void generateEnclosureReport(Enclosure enclosure) {
        System.out.println("\nОТЧЕТ ПО ВОЛЬЕРУ: " + enclosure.getName());
        System.out.println("-".repeat(40));
        System.out.println("Количество животных: " + enclosure.getAnimalCount());

        if (!enclosure.isEmpty()) {
            System.out.println("Животные:");
            for (Animal animal : enclosure.getAnimals()) {
                System.out.println("  • " + animal.getName() + " (" + animal.getSpecies() + ")");
            }
        } else {
            System.out.println("Вольер пуст");
        }
    }
}