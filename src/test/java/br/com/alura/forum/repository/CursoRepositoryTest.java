package br.com.alura.forum.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import br.com.alura.forum.modelo.Curso;

@DataJpaTest
@ActiveProfiles("test")
public class CursoRepositoryTest {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloOSeuNome() {
		String nomeCurso = "HTML 5";
		
		Curso html5 = new Curso(nomeCurso, "Front-end");
		entityManager.persist(html5);
		
		Curso curso = cursoRepository.findByNome(nomeCurso);
		
		Assertions.assertNotNull(curso);
		Assertions.assertEquals(nomeCurso, curso.getNome());
	}
	
	@Test
	public void naoDeveriaCarregarUmCursoCujoONomeNaoEstejaCadastrado() {
		String nomeCurso = "JPA";
		
		Curso curso = cursoRepository.findByNome(nomeCurso);
		
		Assertions.assertNull(curso);
	}

}
