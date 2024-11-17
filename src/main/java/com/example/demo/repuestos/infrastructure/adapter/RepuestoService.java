package com.example.demo.repuestos.infrastructure.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repuestos.domain.RepuestoDTO;
import com.example.demo.repuestos.infrastructure.port.RepuestoServicePort;

@Service
public class RepuestoService implements RepuestoServicePort {
    @Autowired
    private RepuestoRepository repuestoRepository;

    @Override
    public List<RepuestoDTO> listarRepuestos() {
        List<RepuestoEntity> repuestoEntities = repuestoRepository.findAll();

        // Convierte cada RepuestoEntity a RepuestoDTO
        return repuestoEntities.stream()
                .map(this::convertToDTO) // Aplica el método de conversión a cada elemento
                .collect(Collectors.toList()); // Recolecta los resultados en una lista de RepuestoDTO
    }

    // Método de conversión de RepuestoEntity a RepuestoDTO
    private RepuestoDTO convertToDTO(RepuestoEntity entity) {
        return new RepuestoDTO(
                entity.getCodigoInventario(),
                entity.getNombre(),
                entity.getPrecio(),
                entity.getCantidad());
    }

    @Override
    public Optional<RepuestoEntity> findByCodigoInventario(String codigoInventario) {
        return repuestoRepository.findByCodigoInventario(codigoInventario);
    }

    @Override
    public void save(RepuestoEntity repuesto) {
        repuestoRepository.save(repuesto);
    }
}
