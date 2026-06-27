package cl.duoc.api_proveedores.controller;

import cl.duoc.api_proveedores.model.ordenTransitoModel; // Importación agregada
import cl.duoc.api_proveedores.service.proveedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ordenes")
public class proveedorController {

    @Autowired
    private proveedorService service;

    @Operation(summary = "Verifica órdenes en tránsito por ID de fabricante",
            description = "Devuelve el estado de las órdenes en tránsito para un componente específico.")
    @ApiResponse(responseCode = "200", description = "Información encontrada")
    @GetMapping("/{idFabricante}")
    public ResponseEntity<ordenTransitoModel> verificarOrdenesEnTransito(@PathVariable("idFabricante") String idFabricante) {
        return service.obtenerOrdenPorFabricante(idFabricante)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}