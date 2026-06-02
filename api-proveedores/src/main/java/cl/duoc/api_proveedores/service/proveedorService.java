package cl.duoc.api_proveedores.service;

import cl.duoc.api_proveedores.model.ordenTransitoModel;
import cl.duoc.api_proveedores.repository.ordenTransitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class proveedorService {

    @Autowired
    ordenTransitoRepository repository;

    public String verificarStockEnTransito(String idFabricante) {
        Optional<ordenTransitoModel> orden = repository.findByIdFabricante(idFabricante);

        if (orden.isPresent()) {
            ordenTransitoModel datos = orden.get();
            return "Cargamento en tránsito: " + datos.getCantidadEsperada() +
                    " unidades. Llegada estimada: " + datos.getDiasLlegada() +
                    " días (Vía " + datos.getTipoEnvio() + ").";
        }

        return "No ordenes de compara pa dicho fabricante.";
    }
}
