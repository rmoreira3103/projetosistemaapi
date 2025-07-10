package br.com.rafael.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafael.projeto.dto.PerfilDTO;
import br.com.rafael.projeto.entity.PerfilEntity;
import br.com.rafael.projeto.repository.PerfilRepository;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	public List<PerfilDTO> listaTodos() {
		List<PerfilEntity> perfis = perfilRepository.findAll();
		return perfis.stream() .map(PerfilDTO::new).toList();	
	}
	
	public void inserir(PerfilDTO perfil	) {
		PerfilEntity perfilEntity = new PerfilEntity(perfil);
		perfilRepository.save(perfilEntity);
	}
	
	public PerfilDTO alterar(PerfilDTO perfil) {
		PerfilEntity perfilEntinty = new PerfilEntity(perfil);
		return new PerfilDTO(perfilRepository.save(perfilEntinty));
		
	}
	
	public void excluir(Long id) {
		PerfilEntity perfil = perfilRepository.findById(id).get();
		perfilRepository.delete(perfil);
		
	}
	
	public PerfilDTO buscarPorId(Long id) {
		return new PerfilDTO(perfilRepository.findById(id).get());
	}
	

}
