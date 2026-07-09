package cl.duoc.api_proveedores.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrdenTransitoModelValidationTest {

    private static Validator validator;

    @BeforeAll
    static void initValidator() {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
        }
    }

    private ordenTransitoModel crearOrdenValida() {
        ordenTransitoModel orden = new ordenTransitoModel();
        orden.setIdFabricante("FAB-123");
        orden.setCantidadEsperada(50);
        orden.setDiasLlegada(5);
        orden.setTipoEnvio("MARITIMO");
        return orden;
    }

    @Test
    @DisplayName("Una orden con todos los datos correctos pasa la validación")
    void ordenValida_ok() {
        ordenTransitoModel orden = crearOrdenValida();
        Set<ConstraintViolation<ordenTransitoModel>> violaciones = validator.validate(orden);
        assertTrue(violaciones.isEmpty(), "No debería generar violaciones");
    }

    @Test
    @DisplayName("Falla si la cantidad esperada es menor a 1")
    void cantidadInvalida_falla() {
        ordenTransitoModel orden = crearOrdenValida();
        orden.setCantidadEsperada(0);

        Set<ConstraintViolation<ordenTransitoModel>> violaciones = validator.validate(orden);
        assertFalse(violaciones.isEmpty(), "Debe detectar que la cantidad es menor a 1");
    }

    @Test
    @DisplayName("Falla si los días de llegada son negativos")
    void diasNegativos_falla() {
        ordenTransitoModel orden = crearOrdenValida();
        orden.setDiasLlegada(-2);

        Set<ConstraintViolation<ordenTransitoModel>> violaciones = validator.validate(orden);
        assertFalse(violaciones.isEmpty(), "Debe detectar que los días son negativos");
    }

    @Test
    @DisplayName("Falla si el tipo de envío no cumple el patrón permitido")
    void tipoEnvioInvalido_falla() {
        ordenTransitoModel orden = crearOrdenValida();
        orden.setTipoEnvio("TELETRANSPORTACION");

        Set<ConstraintViolation<ordenTransitoModel>> violaciones = validator.validate(orden);
        assertFalse(violaciones.isEmpty(), "Debe detectar el tipo de envío inválido");
    }
}
