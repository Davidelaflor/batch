package com.example.demo.repuestos.application;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repuestos.domain.RepuestoDTO;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestoController {
@Autowired
    private RepuestoApplicationService repuestoApplicationService;

@GetMapping
    public List<RepuestoDTO> listarReouestos() {
        return repuestoApplicationService.listarRepuestos();
    }
}
