package br.com.exeshare;

public class Usuario {

	//Propriedades
	private String nome;
	private String eMail;
	private String dtNasc;
	private String senha;
	
	//M�todos Construtores
	public Usuario(String nome, String eMail, String dtNasc, String senha) {
		
		this.nome = nome;
		this.eMail = eMail;
		this.dtNasc = dtNasc;
		this.senha = senha;
	}
	
}
