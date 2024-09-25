package edu.cibertec.pe.caso_teorico1_backend.controller;

import edu.cibertec.pe.caso_teorico1_backend.dto.ValidacionRequestDTO;
import edu.cibertec.pe.caso_teorico1_backend.dto.ValidacionResponseDTO;
import edu.cibertec.pe.caso_teorico1_backend.service.ValidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validacion")
public class ValidacionController {

    @Autowired
    ValidacionService validacionService;

    @PostMapping("/vehiculo")
    public ValidacionResponseDTO validacion(@RequestBody ValidacionRequestDTO validacionRequestDTO){
        try {
            String[] infovehiculo = validacionService.validacionVehiculo(validacionRequestDTO);

            if(infovehiculo == null){
                return new ValidacionResponseDTO("0", "undefined", "undefined", "undefined", "undefined", "undefined", "undefined");
            }

            return new ValidacionResponseDTO(infovehiculo[0], infovehiculo[1], infovehiculo[2], infovehiculo[3], infovehiculo[4], infovehiculo[5], infovehiculo[6]);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ValidacionResponseDTO("", "", "", "", "", "", "");
        }
    };

}
