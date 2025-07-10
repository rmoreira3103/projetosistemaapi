package br.com.rafael.projeto.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rafael.projeto.entity.UsuarioVerificadorEntity;

public interface UsuarioVerificadorRepository extends JpaRepository<UsuarioVerificadorEntity, Long> {

	public Optional<UsuarioVerificadorEntity> findByUuid(UUID uuid);
}
