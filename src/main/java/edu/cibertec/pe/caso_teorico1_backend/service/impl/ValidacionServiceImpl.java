package edu.cibertec.pe.caso_teorico1_backend.service.impl;

import edu.cibertec.pe.caso_teorico1_backend.dto.ValidacionRequestDTO;
import edu.cibertec.pe.caso_teorico1_backend.service.ValidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class ValidacionServiceImpl implements ValidacionService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] validacionVehiculo(ValidacionRequestDTO validacionRequestDTO) throws Exception{
        String[] infoVehiculo = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))){

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] info = linea.split(";");
                if (validacionRequestDTO.placa().equals(info[1])){
                    infoVehiculo = new String[7];
                    infoVehiculo[0] = info[0];
                    infoVehiculo[1] = info[1];
                    infoVehiculo[2] = info[2];
                    infoVehiculo[3] = info[3];
                    infoVehiculo[4] = info[4];
                    infoVehiculo[5] = info[5];
                    infoVehiculo[6] = info[6];
                }
            }
        } catch (IOException e) {
            infoVehiculo = null;
            throw new Exception(e.getMessage());
        }

        return infoVehiculo;
    };

}
