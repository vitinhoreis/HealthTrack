package br.com.exeshare;

public class Leitura {

	//Propriedades
	private String nomeLivro;
	private String tipoLivro;
	
	//Métodos Construtores
	public Leitura(String nomeLivro, String tipoLivro) {
		
		this.nomeLivro = nomeLivro;
		this.tipoLivro = tipoLivro;
	}
	
	//Métodos
	public void consultarLeitura() {
		
		System.out.println(String.format("Nome do livro: %s\nTipo do Livro: %s", nomeLivro, tipoLivro));
	}
	
}
