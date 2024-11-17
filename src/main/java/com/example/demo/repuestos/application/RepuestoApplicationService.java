package com.example.demo.repuestos.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repuestos.domain.RepuestoDTO;
import com.example.demo.repuestos.infrastructure.port.RepuestoServicePort;

@Service
public class RepuestoApplicationService {
 @Autowired
    private RepuestoServicePort repuestoService;

    // Método para listar todos los repuestos
    public List<RepuestoDTO> listarRepuestos() {
        return repuestoService.listarRepuestos();
    }
}
