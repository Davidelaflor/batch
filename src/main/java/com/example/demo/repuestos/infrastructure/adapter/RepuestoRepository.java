package com.example.demo.repuestos.infrastructure.adapter;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestoRepository extends JpaRepository<RepuestoEntity, String> {
    Optional<RepuestoEntity> findByCodigoInventario(String codigoInventario);

}
