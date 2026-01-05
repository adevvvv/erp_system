package org.example.exhibitions;

import org.example.animals.Animal;
import org.example.care.AnimalCare;

/**
 * Сервис управления выставками.
 * Принцип SRP: отвечает только за работу с выставками.
 * Принцип DIP: реализует интерфейс AnimalCare.
 */
public class ExhibitionService implements AnimalCare {

    private final String exhibitionName;

    public ExhibitionService(String exhibitionName) {
        this.exhibitionName = exhibitionName;
    }

    @Override
    public void provideCare(Animal animal) {
        System.out.println("Сервис выставок обрабатывает: " + animal.getName());

        if (animal instanceof Exhibitable exhibitable) {
            if (exhibitable.canParticipateInExhibition()) {
                System.out.println("Подготовка " + animal.getName() + " к выставке: " + exhibitionName);
                exhibitable.participateInExhibition();
                System.out.println("Сервис выставок: " + animal.getName() + " успешно подготовлен к выставке");
            } else {
                System.out.println("Сервис выставок: " + animal.getName() +
                        " не может участвовать в выставках");
            }
        } else {
            System.out.println("Сервис выставок: " + animal.getName() +
                    " не поддерживает участие в выставках (принцип ISP)");
        }
    }

    @Override
    public String getServiceType() {
        return "Подготовка к выставке: " + exhibitionName;
    }

}