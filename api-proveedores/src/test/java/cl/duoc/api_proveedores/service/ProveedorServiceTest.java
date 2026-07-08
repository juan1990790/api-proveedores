package cl.duoc.api_proveedores.service;

import cl.duoc.api_proveedores.model.ordenTransitoModel;
import cl.duoc.api_proveedores.repository.ordenTransitoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProveedorServiceTest {

    @Mock
    private ordenTransitoRepository repository;

    @InjectMocks
    private proveedorService service;

    private ordenTransitoModel ordenPrueba;

    @BeforeEach
    void setup() {
        ordenPrueba = new ordenTransitoModel();
        ordenPrueba.setIdFabricante("FAB-123");
        ordenPrueba.setCantidadEsperada(100);
        ordenPrueba.setDiasLlegada(10);
        ordenPrueba.setTipoEnvio("AEREO");
    }

    @Test
    void obtenerOrdenPorFabricante_existe() {
        // Arrange
        when(repository.findByIdFabricante("FAB-123")).thenReturn(Optional.of(ordenPrueba));

        // Act
        Optional<ordenTransitoModel> resultado = service.obtenerOrdenPorFabricante("FAB-123");

        // Assert
        assertTrue(resultado.isPresent());
        assertEquals("AEREO", resultado.get().getTipoEnvio());
        verify(repository, times(1)).findByIdFabricante("FAB-123");
    }

    @Test
    void obtenerOrdenPorFabricante_noExiste() {
        // Arrange
        when(repository.findByIdFabricante("NADA")).thenReturn(Optional.empty());

        // Act
        Optional<ordenTransitoModel> resultado = service.obtenerOrdenPorFabricante("NADA");

        // Assert
        assertTrue(resultado.isEmpty());
        verify(repository, times(1)).findByIdFabricante("NADA");
    }
}
