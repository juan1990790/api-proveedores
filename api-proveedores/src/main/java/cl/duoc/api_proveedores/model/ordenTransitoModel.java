package cl.duoc.api_proveedores.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ORDENES_TRANSITO") 
public class ordenTransitoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El ID del fabricante es obligatorio")
    @Column(name = "ID_FABRICANTE", nullable = false, length = 50) 
    private String idFabricante;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser mayor a 0")
    @Column(name = "CANTIDAD_ESPERADA", nullable = false)
    private Integer cantidadEsperada;

    @NotNull(message = "Los días de llegada son obligatorios")
    @Min(value = 0, message = "Los días no pueden ser negativos")
    @Column(name = "DIAS_LLEGADA", nullable = false)
    private Integer diasLlegada;

    @NotBlank(message = "El tipo de envío es obligatorio")
    @Pattern(regexp = "AEREO|MARITIMO|TERRESTRE", message = "Tipo de envío no permitido")
    @Column(name = "TIPO_ENVIO", nullable = false, length = 20)
    private String tipoEnvio;
}
