package org.example.animals;

/**
 * Класс RobotAnimal представляет роботизированное животное в зоопарке.
 * Демонстрирует принцип ISP: не реализует Feedable и MedicalCheckable.
 * Принцип OCP: новый тип животного без изменения существующего кода.
 */
public class RobotAnimal extends AbstractAnimal {
    private final String robotType;
    private final int batteryLevel;

    public RobotAnimal(String name) {
        super(name, "Робот-животное", "Бип-бип!");
        this.robotType = "Механический";
        this.batteryLevel = 100;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " (робот) издает механические звуки");
    }

    @Override
    public String toString() {
        return getName() + " - " + getSpecies() + " (" + robotType + ", заряд: " + batteryLevel + "%)";
    }
}