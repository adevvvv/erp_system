package org.example;

/**
 * Интерфейс MedicalCheckable определяет поведение медицинского осмотра.
 * Принцип ISP: отдельный интерфейс для медицинской функциональности
 */
public interface MedicalCheckable {
    void performMedicalCheckup();
    boolean isHealthy();
    String getMedicalRecord();
}