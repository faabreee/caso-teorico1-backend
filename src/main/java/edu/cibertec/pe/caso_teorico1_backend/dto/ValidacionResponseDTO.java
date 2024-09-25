package edu.cibertec.pe.caso_teorico1_backend.dto;

public record ValidacionResponseDTO(
        String id,
        String placa,
        String marca,
        String modelo,
        String numAsientos,
        String precio,
        String color) {
}
