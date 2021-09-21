package br.com.exeshare;

public class Dieta {
	
	//Propriedades
	private String nomeDieta;
	private double qntCaloriaDia;
	private int nroRefeiDia;

	//Métodos construtores
	public Dieta(String nomeDieta, double qntCaloriaDia, int nroRefeiDia) {
		
		this.nomeDieta = nomeDieta;
		this.qntCaloriaDia = qntCaloriaDia;
		this.nroRefeiDia = nroRefeiDia;
	}
	
	//Métodos
	public void consultarDieta() {
		
		System.out.println(String.format("Nome da Dieta: %s\nQuantidade Diária de Calorias: %sKcal\nNúmero de Refeições Diárias: %s", nomeDieta, qntCaloriaDia, nroRefeiDia));
	}
	
}
