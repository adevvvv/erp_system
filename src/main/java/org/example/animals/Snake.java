package org.example.animals;

/**
 * Класс Snake представляет змею в зоопарке.
 * Демонстрирует возможность добавления новых видов животных.
 * Принцип OCP: добавление без изменения существующего кода.
 */
public class Snake extends AbstractAnimal implements Feedable, MedicalCheckable {

    /**
     * Принцип инкапсуляции: private поле.
     */
    private boolean isHealthy = true;
    private String medicalRecord = "Запись о здоровье змеи";
    public Snake(String name) {
        super(name, "Змея", "Шшшшш!");
    }

    /**
     * Покормить змею.
     * Реализация метода из интерфейса Feedable.
     */
    @Override
    public void feed() {
        System.out.println(name + " (змея) получает грызунов");
    }
    @Override
    public String getFeedingSchedule() {
        return "Кормить один раз в неделю";
    }
    @Override
    public String getFoodType() {
        return "Грызуны";
    }

    /**
     * Провести медицинский осмотр змеи.
     * Реализация метода из интерфейса MedicalCheckable.
     */
    @Override
    public void performMedicalCheckup() {
        System.out.println("Проводим медицинский осмотр змеи: " + name);
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