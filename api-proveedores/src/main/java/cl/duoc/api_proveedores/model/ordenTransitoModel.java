package cl.duoc.api_proveedores.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ordenes_transito")
public class ordenTransitoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "id_fabricante")
    private String idFabricante;

    @Column(nullable = false, name = "cantidad_esperada")
    private Integer cantidadEsperada;

    @Column(nullable = false, name = "dias_llegada")
    private Integer diasLlegada;

    @Column(nullable = false, name = "tipo_envio")
    private String tipoEnvio; // Ej: "Aéreo", "Marítimo"
}
