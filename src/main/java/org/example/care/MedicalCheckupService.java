package org.example.care;

import org.example.animals.*;

/**
 * Сервис медицинских осмотров.
 * Принцип SRP: отвечает только за медицинские осмотры.
 * Принцип DIP: реализует интерфейс AnimalCare.
 */
public class MedicalCheckupService implements AnimalCare {
    @Override
    public void provideCare(Animal animal) {
        if (animal instanceof MedicalCheckable medicalAnimal) {
            medicalAnimal.performMedicalCheckup();
            System.out.println("Сервис медосмотра: " + animal.getName() + " прошел осмотр");
        } else {
            System.out.println("Сервис медосмотра: " + animal.getName() +
                    " не может быть осмотрен этим сервисом");
        }
    }
    @Override
    public String getCareType() {
        return "Медицинский осмотр";
    }
}