package org.example.animals;

/**
 * Класс Parrot представляет попугая в зоопарке.
 * Принцип LSP: может заменить AbstractAnimal без проблем.
 * Демонстрирует разное поведение для разных видов.
 */
public class Parrot extends AbstractAnimal implements Feedable, MedicalCheckable {

    /**
     * Принцип инкапсуляции: private поле.
     */
    private boolean isHealthy = true;
    private String medicalRecord = "Запись о здоровье попугая";
    public Parrot(String name) {
        super(name, "Попугай", "Чирик-чирик!");
    }

    /**
     * Покормить попугая.
     * Реализация метода из интерфейса Feedable.
     */
    @Override
    public void feed() {
        System.out.println(name + " (попугай) получает зерно и фрукты");
    }
    @Override
    public String getFeedingSchedule() {
        return "Кормить три раза в день: 8:00, 12:00, 18:00";
    }
    @Override
    public String getFoodType() {
        return "Зерно и фрукты";
    }

    /**
     * Провести медицинский осмотр попугая.
     * Реализация метода из интерфейса MedicalCheckable.
     */
    @Override
    public void performMedicalCheckup() {
        System.out.println("Проводим медицинский осмотр попугая: " + name);
        isHealthy = true;
    }
    @Override
    public boolean isHealthy() {
        return isHealthy;
    }
    @Override
    public String getMedicalRecord() {
        return medicalRecord;
    }
}