package br.com.rafael.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafael.projeto.dto.PerfilUsuarioDTO;
import br.com.rafael.projeto.dto.UsuarioDTO;
import br.com.rafael.projeto.entity.PerfilUsuarioEntity;
import br.com.rafael.projeto.entity.UsuarioEntity;
import br.com.rafael.projeto.repository.PerfilUsuarioRepository;
import br.com.rafael.projeto.repository.UsuarioRepository;

@Service
public class PerfilUsuarioService {
	
	@Autowired
	private PerfilUsuarioRepository perfilUsuarioRepository; 
	
	public List<PerfilUsuarioDTO> listarTodos(){
		List<PerfilUsuarioEntity> perfilUsuario = perfilUsuarioRepository.findAll();
		return perfilUsuario.stream().map(PerfilUsuarioDTO::new).toList();
	}	
		
	public void inserir(PerfilUsuarioDTO perfilUsuario) {
		PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(perfilUsuario);
		perfilUsuarioRepository.save(perfilUsuarioEntity);			
	}
	public PerfilUsuarioDTO alterar(PerfilUsuarioDTO perfilUsuario) {
		PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(perfilUsuario);
		return new PerfilUsuarioDTO(perfilUsuarioRepository.save(perfilUsuarioEntity));
	}
	
	public void excluir(Long id) { 
		PerfilUsuarioEntity perfilUsuario = perfilUsuarioRepository.findById(id).get();
		perfilUsuarioRepository.delete(perfilUsuario);
	}
	
	public PerfilUsuarioDTO buscarPorId(Long id) {
		return new PerfilUsuarioDTO(perfilUsuarioRepository.findById(id).get());
	}


}
