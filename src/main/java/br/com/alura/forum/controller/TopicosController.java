package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@GetMapping
	public List<TopicoDto> lista(){
				
		Topico topico1 = new Topico("Dúvida JPA/hibernate", "Como mapear a entidade?", 
				new Curso("JPA/Hibernate", "Programação"));
		
		Topico topico2 = new Topico("Dúvida Spring", "Como criar um endpoint?", 
				new Curso("Spring Boot", "Programação"));

		return TopicoDto.converte(Arrays.asList(topico1, topico2));
	}
}
