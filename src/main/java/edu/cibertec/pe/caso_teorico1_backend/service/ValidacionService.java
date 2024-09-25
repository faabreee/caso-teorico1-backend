package edu.cibertec.pe.caso_teorico1_backend.service;

import edu.cibertec.pe.caso_teorico1_backend.dto.ValidacionRequestDTO;

public interface ValidacionService {

    String[] validacionVehiculo(ValidacionRequestDTO validacionRequestDTO) throws Exception;

}
