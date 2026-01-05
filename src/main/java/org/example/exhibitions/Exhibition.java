package org.example.exhibitions;

import org.example.animals.Animal;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс Exhibition представляет выставку в зоопарке.
 * Принцип SRP: отвечает только за управление выставкой.
 */
public class Exhibition {
    private final String name;
    private final String description;
    private final List<Animal> participants;

    public Exhibition(String name, String description) {
        this.name = name;
        this.description = description;
        this.participants = new ArrayList<>();
    }

    public void addParticipant(Animal animal) {
        if (animal instanceof Exhibitable exhibitable) {
            if (exhibitable.canParticipateInExhibition()) {
                participants.add(animal);
                System.out.println(animal.getName() + " добавлен в выставку \"" + name + "\"");
            } else {
                System.out.println(animal.getName() + " не может участвовать в выставках");
            }
        } else {
            System.out.println(animal.getName() + " не поддерживает участие в выставках");
        }
    }

    public void startExhibition() {
        if (participants.isEmpty()) {
            System.out.println("Невозможно начать выставку \"" + name + "\": нет участников");
            return;
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.println("НАЧАЛО ВЫСТАВКИ: " + name);
        System.out.println("Описание: " + description);
        System.out.println("=".repeat(60));

        System.out.println("Подготовка участников:");
        for (Animal animal : participants) {
            if (animal instanceof Exhibitable exhibitable) {
                System.out.println("- " + animal.getName() + ": " + exhibitable.getExhibitionPreparation());
            }
        }

        System.out.println("\nВыступление участников:");
        for (Animal animal : participants) {
            if (animal instanceof Exhibitable exhibitable) {
                exhibitable.participateInExhibition();
            }
        }

        System.out.println("=".repeat(60));
        System.out.println("ВЫСТАВКА \"" + name + "\" УСПЕШНО ЗАВЕРШЕНА!");
        System.out.println("=".repeat(60));
    }

    public String getName() {
        return name;
    }

    public int getParticipantCount() {
        return participants.size();
    }

}