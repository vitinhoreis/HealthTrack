package br.com.exeshare;

public class Teste {
	
	//Criando inst�ncias da classe Perfil
	static Perfil perfilVitor = new Perfil("Apaixonado por Tecnologia", 1.68, 65, 33);
	
	//Criando inst�ncias da classe Atividade
	static Atividade atividadeCorrida = new Atividade("Corrida", "Exerc�cio", "(02/05/2021), (06/05/2021)");
	

	public static void main(String[] args) {
		
		//Invocando os M�todos
		perfilVitor.consultarPerfil();
		
		System.out.println("-----------------");
		
		atividadeCorrida.consultarAtividade();

	}

}
