package br.com.exeshare;

public class Exercicio {
	
	//Propriedades
	private String nomeExer;
	private String tipoExer;
	private String nvlDific;
	private String qntTempo; 
	
	//M�todos Construtores
	public Exercicio(String nomeExer, String tipoExer, String nvlDific, String qntTempo) {
		
		this.nomeExer = nomeExer;
		this.tipoExer = tipoExer;
		this.nvlDific = nvlDific;
		this.qntTempo = qntTempo;
	}
	
	//M�todos
	public void consultarExercicio() {
		
		System.out.println(String.format("Nome do Exerc�cio: %s\nTipo de Exerc�cio: %s\nN�vel de Dificuldade: %s\nQuantidade de Tempo: %s", nomeExer, tipoExer, nvlDific, qntTempo));
	}
}
