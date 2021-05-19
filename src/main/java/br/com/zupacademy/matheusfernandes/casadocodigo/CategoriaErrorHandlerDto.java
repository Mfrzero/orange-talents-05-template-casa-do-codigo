package br.com.zupacademy.matheusfernandes.casadocodigo;

public class CategoriaErrorHandlerDto {

	private String campo;
	private String mensagem;
	
	public CategoriaErrorHandlerDto(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}
	public String getCampo() {
		return campo;
	}
	public String getMensagem() {
		return mensagem;
	}
}
