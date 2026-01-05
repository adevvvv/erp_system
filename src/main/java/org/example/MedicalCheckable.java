package org.example;

/**
 * Интерфейс MedicalCheckable определяет поведение медицинского осмотра.
 * Принцип ISP: отдельный интерфейс для медицинской функциональности.
 * Только те животные, которые нуждаются в медосмотре, реализуют этот интерфейс.
 */
public interface MedicalCheckable {
    void performMedicalCheckup();
    boolean isHealthy();
    String getMedicalRecord();
}