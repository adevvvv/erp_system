package org.example.animals;

/**
 * Интерфейс Feedable определяет поведение кормления.
 * Принцип ISP: отдельный интерфейс для функциональности кормления.
 * Только те животные, которых нужно кормить, реализуют этот интерфейс.
 */
public interface Feedable {
    void feed();
    String getFeedingSchedule();
    String getFoodType();
}