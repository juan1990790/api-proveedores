package cl.duoc.api_proveedores.service;

import cl.duoc.api_proveedores.model.ordenTransitoModel;
import cl.duoc.api_proveedores.repository.ordenTransitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class proveedorService {

    @Autowired
    private ordenTransitoRepository repository;

    public Optional<ordenTransitoModel> obtenerOrdenPorFabricante(String idFabricante) {
        return repository.findByIdFabricante(idFabricante);
    }
}
