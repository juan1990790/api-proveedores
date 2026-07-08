package cl.duoc.api_proveedores.controller;

import cl.duoc.api_proveedores.model.ordenTransitoModel;
import cl.duoc.api_proveedores.service.proveedorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProveedorControllerTest {

    @Mock
    private proveedorService service;

    @InjectMocks
    private proveedorController controller;

    private ordenTransitoModel ordenPrueba;

    @BeforeEach
    void setup() {
        ordenPrueba = new ordenTransitoModel();
        ordenPrueba.setIdFabricante("FAB-123");
        ordenPrueba.setCantidadEsperada(20);
        ordenPrueba.setDiasLlegada(2);
        ordenPrueba.setTipoEnvio("TERRESTRE");
    }

    @Test
    void verificarOrdenesEnTransito_existe_responde200() {
        
        when(service.obtenerOrdenPorFabricante("FAB-123")).thenReturn(Optional.of(ordenPrueba));

        ResponseEntity<ordenTransitoModel> resp = controller.verificarOrdenesEnTransito("FAB-123");

        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertNotNull(resp.getBody());
        assertEquals(20, resp.getBody().getCantidadEsperada());
        verify(service, times(1)).obtenerOrdenPorFabricante("FAB-123");
    }

    @Test
    void verificarOrdenesEnTransito_noExiste_responde404() {

        when(service.obtenerOrdenPorFabricante("NADA")).thenReturn(Optional.empty());

        ResponseEntity<ordenTransitoModel> resp = controller.verificarOrdenesEnTransito("NADA");

        assertEquals(HttpStatus.NOT_FOUND, resp.getStatusCode());
        verify(service, times(1)).obtenerOrdenPorFabricante("NADA");
    }
}
