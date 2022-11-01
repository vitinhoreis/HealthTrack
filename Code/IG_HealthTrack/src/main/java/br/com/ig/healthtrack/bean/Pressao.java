package br.com.ig.healthtrack.bean;

import java.util.Calendar;

public class Pressao {
	

	private int codigo;
	private int codigoUsuario;
	private int sistolica;
	private int diastolica;
	private String classificacao;
	private Calendar dataHoraMedicao;
	
	public Pressao(int codigo, int codigoUsuario, int sistolica, int diastolica, String classificacao,
			Calendar dataHoraMedicao) {
		super();
		this.codigo = codigo;
		this.codigoUsuario = codigoUsuario;
		this.sistolica = sistolica;
		this.diastolica = diastolica;
		this.classificacao = classificacao;
		this.dataHoraMedicao = dataHoraMedicao;
	}
	
	
	
	public Pressao() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public int getSistolica() {
		return sistolica;
	}
	public void setSistolica(int sistolica) {
		this.sistolica = sistolica;
	}
	public int getDiastolica() {
		return diastolica;
	}
	public void setDiastolica(int diastolica) {
		this.diastolica = diastolica;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public Calendar getDataHoraMedicao() {
		return dataHoraMedicao;
	}
	public void setDataHoraMedicao(Calendar dataHoraMedicao) {
		this.dataHoraMedicao = dataHoraMedicao;
	}

}
