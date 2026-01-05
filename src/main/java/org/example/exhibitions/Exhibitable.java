package org.example.exhibitions;

/**
 * Интерфейс Exhibitable определяет поведение для участия в выставках.
 * Принцип ISP: отдельный интерфейс для выставочной функциональности.
 * Только те животные, которые могут участвовать в выставках, реализуют этот интерфейс.
 */
public interface Exhibitable {
    boolean canParticipateInExhibition();
    String getExhibitionPreparation();
    void participateInExhibition();
}