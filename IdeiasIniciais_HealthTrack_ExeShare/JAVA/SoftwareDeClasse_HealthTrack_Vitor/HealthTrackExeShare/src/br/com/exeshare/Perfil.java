package br.com.exeshare;

public class Perfil {
	
	//Propriedades
	private String biografia;
	private double altura;
	private double peso;
	private int nroSeguidor;
	
	//M�todos construtores
	public Perfil(String biografia, double altura, double peso, int nroSeguidor) {
	
		this.biografia = biografia;
		this.altura = altura;
		this.peso = peso;
		this.nroSeguidor = nroSeguidor;
	}
	
	
	//M�todos
	public void consultarPerfil() {
		
		System.out.println(String.format("Biografia: %s\nAltura: %sm\nPeso: %skg\nN�mero de Seguidores: %s", biografia, altura, peso, nroSeguidor));
	}

}
