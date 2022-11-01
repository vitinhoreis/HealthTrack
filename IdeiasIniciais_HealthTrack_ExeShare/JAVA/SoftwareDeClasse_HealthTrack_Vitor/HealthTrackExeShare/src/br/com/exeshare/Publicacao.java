package br.com.exeshare;

public class Publicacao {

	//Propriedades
	private String descricao;
	private int nroLike;
	private String comentario;
	
	//M�todos Construtores
	public Publicacao(String descricao, int nroLike, String comentario) {
		
		this.descricao = descricao;
		this.nroLike = nroLike;
		this.comentario = comentario;
	}
	
	//M�todos
	public void consultarPublicacao() {
		
		System.out.println(String.format("Descri��o: %s\nN�mero de Curtidas: %s\nComent�rios: %s: ", descricao, nroLike, comentario));
	}
	
}
