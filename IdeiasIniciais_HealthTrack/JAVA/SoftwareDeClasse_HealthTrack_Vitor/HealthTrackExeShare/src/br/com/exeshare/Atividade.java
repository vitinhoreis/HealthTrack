package br.com.exeshare;

public class Atividade {
	
	//Propriedades
	private String nomeAtv;
	private String tipoAtv;
	private String historico;
	
	//Métodos Construtores
	public Atividade(String nomeAtv, String tipoAtv, String historico) {
		
		this.nomeAtv = nomeAtv;
		this.tipoAtv = tipoAtv;
		this.historico = historico;
	}

	//Métodos 
	public void consultarAtividade() {
		System.out.println(String.format("Nome da Atividade: %s\nTipo da Atividade: %s\nHistórico: %s", nomeAtv, tipoAtv, historico));
	}
}
