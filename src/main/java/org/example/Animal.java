package org.example;

/**
 * Интерфейс Animal представляет базовый контракт для всех животных в зоопарке.
 * Принцип ISP: разделен на специализированные интерфейсы.
 * Каждое животное должно реализовать этот интерфейс.
 */
public interface Animal {
    String getName();
    String getSpecies();
    void makeSound();
}