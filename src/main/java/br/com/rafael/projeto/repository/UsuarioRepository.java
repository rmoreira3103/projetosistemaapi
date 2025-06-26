package br.com.rafael.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rafael.projeto.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
