package com.example.demo;

import com.example.demo.repuestos.infrastructure.adapter.RepuestoEntity;
import com.example.demo.repuestos.infrastructure.adapter.RepuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class RepuestoBatchRunner implements CommandLineRunner {

    @Autowired
    private RepuestoRepository repuestoRepository;

    @Override
    public void run(String... args) throws Exception {
        // Llamamos al método que actualiza las cantidades aleatorias
        actualizarCantidadAleatoriaRepuestos();
    }

    // Método para actualizar las cantidades de repuestos aleatorios
    private void actualizarCantidadAleatoriaRepuestos() {
        Random random = new Random();

        // Obtener todos los repuestos de la base de datos
        List<RepuestoEntity> repuestos = repuestoRepository.findAll();

        // Si no hay repuestos, no hacer nada
        if (repuestos.isEmpty()) {
            System.out.println("No hay repuestos en la base de datos.");
            return;
        }

        // Seleccionar un número aleatorio de repuestos a actualizar (por ejemplo, entre 1 y 5)
        int cantidadDeRepuestosAleatorios = random.nextInt(5) + 1; // Selecciona entre 1 y 5 repuestos aleatorios

        // Seleccionar los repuestos aleatorios
        for (int i = 0; i < cantidadDeRepuestosAleatorios; i++) {
            int indiceAleatorio = random.nextInt(repuestos.size()); // Selecciona un índice aleatorio
            RepuestoEntity repuesto = repuestos.get(indiceAleatorio); // Obtiene el repuesto

            // Sumar una cantidad aleatoria entre 1 y 10 a la cantidad actual
            int cantidadAleatoria = random.nextInt(10) + 1; // Genera un número aleatorio entre 1 y 10
            int nuevaCantidad = repuesto.getCantidad() + cantidadAleatoria; // Suma la cantidad aleatoria

            // Actualiza la cantidad del repuesto
            repuesto.setCantidad(nuevaCantidad);
            repuestoRepository.save(repuesto); // Guarda el repuesto actualizado en la base de datos

            System.out.println("Repuesto actualizado: " + repuesto.getNombre() +
                               " | Nueva cantidad: " + nuevaCantidad);
        }
    }
}
