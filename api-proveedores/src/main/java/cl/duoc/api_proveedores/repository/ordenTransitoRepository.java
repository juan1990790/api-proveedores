package cl.duoc.api_proveedores.repository;

import cl.duoc.api_proveedores.model.ordenTransitoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

@Repository
public interface ordenTransitoRepository extends JpaRepository<ordenTransitoModel, Long> {

    Optional<ordenTransitoModel> findByIdFabricante(String idFabricante);

    boolean existsByIdFabricante(String idFabricante);
}