package br.com.exeshare;

public class Exercicio {
	
	//Propriedades
	private String nomeExer;
	private String tipoExer;
	private String nvlDific;
	private String qntTempo; 
	
	//Métodos Construtores
	public Exercicio(String nomeExer, String tipoExer, String nvlDific, String qntTempo) {
		
		this.nomeExer = nomeExer;
		this.tipoExer = tipoExer;
		this.nvlDific = nvlDific;
		this.qntTempo = qntTempo;
	}
	
	//Métodos
	public void consultarExercicio() {
		
		System.out.println(String.format("Nome do Exercício: %s\nTipo de Exercício: %s\nNível de Dificuldade: %s\nQuantidade de Tempo: %s", nomeExer, tipoExer, nvlDific, qntTempo));
	}
}
