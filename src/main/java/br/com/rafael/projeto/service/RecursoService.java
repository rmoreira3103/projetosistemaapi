package br.com.rafael.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafael.projeto.dto.RecursoDTO;
import br.com.rafael.projeto.entity.RecursoEntity;
import br.com.rafael.projeto.repository.RecursoRepository;

@Service
public class RecursoService {
	
	@Autowired
	private RecursoRepository recursoRepository;
	
	public List<RecursoDTO> listaTodos() {
		List<RecursoEntity> recursos = recursoRepository.findAll();
		return recursos.stream() .map(RecursoDTO::new).toList();	
	}
	
	public void inserir(RecursoDTO recurso) {
		RecursoEntity recursoEntity = new RecursoEntity(recurso);
		recursoRepository.save(recursoEntity);
	}
	
	public RecursoDTO alterar(RecursoDTO recurso) {
		RecursoEntity recursoEntinty = new RecursoEntity(recurso);
		return new RecursoDTO(recursoRepository.save(recursoEntinty));
		
	}
	
	public void excluir(Long id) {
		RecursoEntity recurso = recursoRepository.findById(id).get();
		recursoRepository.delete(recurso);
		
	}
	
	public RecursoDTO buscarPorId(Long id) {
		return new RecursoDTO(recursoRepository.findById(id).get());
	}
	

}
