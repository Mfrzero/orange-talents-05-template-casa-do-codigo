package br.com.zupacademy.matheusfernandes.casadocodigo;

public class ErrorHandlerDto {

	private String campo;
	private String erro;
	
	public ErrorHandlerDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}
	public String getCampo() {
		return campo;
	}
	public String getErro() {
		return erro;
	}
	
	
}
