package br.com.exeshare;

public class Perfil {
	
	//Propriedades
	private String biografia;
	private double altura;
	private double peso;
	private int nroSeguidor;
	
	//Métodos construtores
	public Perfil(String biografia, double altura, double peso, int nroSeguidor) {
	
		this.biografia = biografia;
		this.altura = altura;
		this.peso = peso;
		this.nroSeguidor = nroSeguidor;
	}
	
	
	//Métodos
	public void consultarPerfil() {
		
		System.out.println(String.format("Biografia: %s\nAltura: %sm\nPeso: %skg\nNúmero de Seguidores: %s", biografia, altura, peso, nroSeguidor));
	}

}
