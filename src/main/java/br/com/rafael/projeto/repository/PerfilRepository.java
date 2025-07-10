package br.com.rafael.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rafael.projeto.entity.PerfilEntity;

public interface PerfilRepository extends JpaRepository<PerfilEntity, Long> {

}