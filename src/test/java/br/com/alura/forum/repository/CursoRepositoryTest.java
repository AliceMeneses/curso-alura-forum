package br.com.alura.forum.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.alura.forum.modelo.Curso;

@DataJpaTest
public class CursoRepositoryTest {
	
	@Autowired
	private CursoRepository cursoRepository;

	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloOSeuNome() {
		String nomeCurso = "HTML 5";
		
		Curso curso = cursoRepository.findByNome(nomeCurso);
		
		Assert.assertNotNull(curso);
		Assert.assertEquals(nomeCurso, curso.getNome());
	}
	
	@Test
	public void naoDeveriaCarregarUmCursoCujoONomeNaoEstejaCadastrado() {
		String nomeCurso = "JPA";
		
		Curso curso = cursoRepository.findByNome(nomeCurso);
		
		Assert.assertNull(curso);
	}

}
