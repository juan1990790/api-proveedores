package cl.duoc.api_proveedores.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="IMPORTACIONES")
@AllArgsConstructor
@NoArgsConstructor

public class proveedorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El ID de fabricante es obligatorio")
    @Column(name = "ID_FABRICANTE", nullable = false)
    private String idFabricante;

    @NotBlank(message = "El nombre del componente es obligatorio")
    @Column(name = "NOMBRE_COMPONENTE", nullable = false)
    private String nombreComponente;

    @Positive(message = "La cantidad en tránsito debe ser mayor a cero")
    @Column(name = "CANTIDAD_TRANSITO", nullable = false)
    private Integer cantidadEnTransito;

    @NotBlank(message = "Debe indicar el estado del envío")
    @Column(name = "ESTADO_ENVIO", nullable = false)
    private String estadoEnvio;

    @Column(name = "FECHA_ESTIMADA")
    private String fechaEstimadaArribo;
}
