package org.example;

/**
 * Интерфейс Animal представляет базовый контракт для всех животных в зоопарке.
 * Принцип ISP: разделен на специализированные интерфейсы
 */
public interface Animal {
    String getName();
    String getSpecies();
    void makeSound();
}