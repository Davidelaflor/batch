package com.example.demo.repuestos.infrastructure.port;

import java.util.List;
import java.util.Optional;

import com.example.demo.repuestos.domain.RepuestoDTO;
import com.example.demo.repuestos.infrastructure.adapter.RepuestoEntity;

public interface RepuestoServicePort {

    List<RepuestoDTO> listarRepuestos();

    Optional<RepuestoEntity> findByCodigoInventario(String codigoInventario);

    void save(RepuestoEntity repuesto);

}
