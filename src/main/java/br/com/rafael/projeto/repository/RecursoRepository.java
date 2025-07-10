package br.com.rafael.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rafael.projeto.entity.RecursoEntity;

public interface RecursoRepository extends JpaRepository<RecursoEntity, Long> {

}
