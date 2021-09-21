package br.com.exeshare;

public class Dieta {
	
	//Propriedades
	private String nomeDieta;
	private double qntCaloriaDia;
	private int nroRefeiDia;

	//M�todos construtores
	public Dieta(String nomeDieta, double qntCaloriaDia, int nroRefeiDia) {
		
		this.nomeDieta = nomeDieta;
		this.qntCaloriaDia = qntCaloriaDia;
		this.nroRefeiDia = nroRefeiDia;
	}
	
	//M�todos
	public void consultarDieta() {
		
		System.out.println(String.format("Nome da Dieta: %s\nQuantidade Di�ria de Calorias: %sKcal\nN�mero de Refei��es Di�rias: %s", nomeDieta, qntCaloriaDia, nroRefeiDia));
	}
	
}
