package br.com.exeshare;

public class Publicacao {

	//Propriedades
	private String descricao;
	private int nroLike;
	private String comentario;
	
	//Métodos Construtores
	public Publicacao(String descricao, int nroLike, String comentario) {
		
		this.descricao = descricao;
		this.nroLike = nroLike;
		this.comentario = comentario;
	}
	
	//Métodos
	public void consultarPublicacao() {
		
		System.out.println(String.format("Descrição: %s\nNúmero de Curtidas: %s\nComentários: %s: ", descricao, nroLike, comentario));
	}
	
}
