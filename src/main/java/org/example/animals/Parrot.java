package org.example.animals;

import org.example.exhibitions.Exhibitable;

/**
 * Класс Parrot представляет попугая в зоопарке.
 * Принцип LSP: может заменить AbstractAnimal без проблем.
 * Демонстрирует разное поведение для разных видов.
 */
public class Parrot extends AbstractAnimal implements Feedable, MedicalCheckable, Exhibitable {

    /**
     * Принцип инкапсуляции: private поле.
     */
    private boolean isHealthy = true;

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
        return "Запись о здоровье попугая";
    }
    @Override
    public boolean canParticipateInExhibition() {
        return true;
    }

    @Override
    public String getExhibitionPreparation() {
        return "Подготовить к выставке: почистить перья, проверить способности к разговору";
    }

    @Override
    public void participateInExhibition() {
        System.out.println(name + " (попугай) демонстрирует разговорные навыки на выставке птиц!");
    }
}