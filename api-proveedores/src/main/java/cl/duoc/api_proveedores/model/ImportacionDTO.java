package cl.duoc.api_proveedores.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImportacionDTO {

    private String idFabricante;
    private String estadoEnvio;
    private String mensajeInformativo;

}