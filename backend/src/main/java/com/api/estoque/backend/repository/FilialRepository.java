package com.api.estoque.backend.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.estoque.backend.model.Filial;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Long> {
    public Optional<Filial>findByCnpj(String cnpj);

    public Page<Filial>findByNameContaining(String name,  Pageable pageable);

    @Query(value = "SELECT * FROM filial WHERE usuario_id= ?1", nativeQuery = true)
    public Optional<Filial>findByusuario_id(Long id);
}
