package cl.duoc.api_proveedores.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ordenes")
public class proveedorController {

    @GetMapping("/{idFabricante}")
    public String verificarOrdenesEnTransito(@PathVariable("idFabricante") String idFabricante) {
        
        if (idFabricante.startsWith("INTEL")) {
            return "Cargamento en tránsito: 50 unidades. Llegada estimada: 3 días (Vía Aérea).";
        } else if (idFabricante.startsWith("AMD")) {
            return "Cargamento en tránsito: 200 unidades. Llegada estimada: 15 días (Vía Marítima).";
        } else {
            return "Cargamento en tránsito: 15 unidades. Llegada estimada: 5 días.";
        }
    }
}
