package org.example.care;

import org.example.animals.Animal;
import org.example.animals.MedicalCheckable;

public class AdmissionMedicalService implements AnimalCare {
    @Override
    public void provideCare(Animal animal) {
        System.out.println("МЕДОСМОТР ПРИ ПРИЕМЕ: " + animal.getName());

        if (animal instanceof MedicalCheckable medical) {
            System.out.println("Проводим полный медосмотр...");
            medical.performMedicalCheckup();
            System.out.println("Результат: " + (medical.isHealthy() ? "ГОДЕН" : "НЕ ГОДЕН"));
            System.out.println("Заведена медицинская карта");
        } else {
            System.out.println(animal.getName() + " не требует медосмотра при приеме");
        }
        System.out.println(animal.getName() + " принят в зоопарк!");
    }

    @Override
    public String getServiceType() {
        return "Медосмотр при приеме";
    }
}