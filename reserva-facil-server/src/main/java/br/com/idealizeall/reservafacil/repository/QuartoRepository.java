package br.com.idealizeall.reservafacil.repository;

import br.com.idealizeall.reservafacil.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {

}

