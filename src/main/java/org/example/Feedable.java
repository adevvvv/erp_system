package org.example;

/**
 * Интерфейс Feedable определяет поведение кормления.
 * Принцип ISP: отдельный интерфейс для функциональности кормления
 */
public interface Feedable {
    void feed();
    String getFeedingSchedule();
    String getFoodType();
}