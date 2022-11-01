package br.com.exeshare;

public class Alimento {
	
	//Propriedades
	private String nomeAlimento;
	private String tipoAlimento;
	private double qntCaloria;

	//M�todos Construtores
	public Alimento(String nomeAlimento, String tipoAlimento, double qntCaloria) {
		
		this.nomeAlimento = nomeAlimento;
		this.tipoAlimento = tipoAlimento;
		this.qntCaloria = qntCaloria;
	}
	
	//M�todos
	public void consultarAlimento() {
		
		System.out.println(String.format("Nome do Alimento: %s\nTipo de Alimento: %s\nQuantidade de Calorias: %sKcal", nomeAlimento, tipoAlimento, qntCaloria));
	}
	
}
