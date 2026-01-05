package org.example;

/**
 * Класс Lion представляет льва в зоопарке.
 * Принцип OCP: добавляем новый вид животных без изменения существующего кода.
 * Принцип LSP: может заменять AbstractAnimal без проблем.
 */
public class Lion extends AbstractAnimal implements Feedable, MedicalCheckable {

    /**
     * Принцип инкапсуляции: private поле.
     */
    private boolean isHealthy = true;
    private String medicalRecord = "Запись о здоровье льва";
    public Lion(String name) {
        super(name, "Лев", "Ррррр!");
    }

    /**
     * Покормить льва.
     * Реализация метода из интерфейса Feedable.
     */
    @Override
    public void feed() {
        System.out.println(name + " (лев) получает мясо");
    }
    @Override
    public String getFeedingSchedule() {
        return "Кормить два раза в день: 9:00 и 17:00";
    }
    @Override
    public String getFoodType() {
        return "Мясо";
    }

    /**
     * Провести медицинский осмотр льва.
     * Реализация метода из интерфейса MedicalCheckable.
     */
    @Override
    public void performMedicalCheckup() {
        System.out.println("Проводим медицинский осмотр льва: " + name);
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