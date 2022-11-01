package br.com.exeshare;

public class Leitura {

	//Propriedades
	private String nomeLivro;
	private String tipoLivro;
	
	//M�todos Construtores
	public Leitura(String nomeLivro, String tipoLivro) {
		
		this.nomeLivro = nomeLivro;
		this.tipoLivro = tipoLivro;
	}
	
	//M�todos
	public void consultarLeitura() {
		
		System.out.println(String.format("Nome do livro: %s\nTipo do Livro: %s", nomeLivro, tipoLivro));
	}
	
}
