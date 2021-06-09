package br.com.alura.forum.controller.dto;

public class TokenDto {

	private String token;
	private String tipoAutenticao;

	public TokenDto(String token, String tipoAutenticacao) {
		this.token = token;
		this.tipoAutenticao = tipoAutenticacao;
	}

	public String getToken() {
		return token;
	}

	public String getTipoAutenticao() {
		return tipoAutenticao;
	}

}
