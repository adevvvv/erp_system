package org.example.care;

import org.example.animals.*;

/**
 * Сервис медицинских осмотров.
 * Принцип SRP: отвечает только за медицинские осмотры.
 */
public class MedicalService implements AnimalCare {

    @Override
    public void provideCare(Animal animal) {
        System.out.println("Начинаем медицинский осмотр: " + animal.getName());

        if (animal instanceof MedicalCheckable medical) {
            medical.performMedicalCheckup();
            System.out.println("  Результат: " +
                    (medical.isHealthy() ? "Здоров" : "Требует лечения"));
            System.out.println("  Запись в карте: " + medical.getMedicalRecord());
        } else {
            System.out.println("  " + animal.getName() + " не требует медосмотра");
        }
    }

    @Override
    public String getServiceType() {
        return "Медицинский осмотр";
    }
}