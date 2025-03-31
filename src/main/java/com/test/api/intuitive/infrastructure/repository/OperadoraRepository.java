package com.test.api.intuitive.infrastructure.repository;

import com.test.api.intuitive.infrastructure.model.Operadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface OperadoraRepository extends JpaRepository<Operadora, UUID> {

    @Query("SELECT o FROM Operadora o WHERE LOWER(o.cnpj) LIKE LOWER(CONCAT('%', :cnpj, '%'))")
    List<Operadora> findByCnpj(@Param("cnpj") String cnpj);

    List<Operadora> findByRazaoSocialContainingIgnoreCase(@Param("razaoSocial") String razaoSocial);
}
