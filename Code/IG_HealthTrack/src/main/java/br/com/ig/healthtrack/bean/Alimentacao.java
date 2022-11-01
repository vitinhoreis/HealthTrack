package br.com.ig.healthtrack.bean;

import java.util.Calendar;

public class Alimentacao {
	
	public Alimentacao(int codigo, int codigoUsuario, int codigoTipoRefeicao, String descricao, Calendar dataHora,
			double calorias, double gramas) {
		super();
		this.codigo = codigo;
		this.codigoUsuario = codigoUsuario;
		this.codigoTipoRefeicao = codigoTipoRefeicao;
		this.descricao = descricao;
		this.dataHora = dataHora;
		this.calorias = calorias;
		this.gramas = gramas;
	}
	
	public Alimentacao() {
		super();
	}
	private int codigo;
	private int codigoUsuario;
	private int codigoTipoRefeicao;
	private String descricao;
	private Calendar dataHora;
	private double calorias;
	private double gramas;
	
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
	public int getCodigoTipoRefeicao() {
		return codigoTipoRefeicao;
	}
	public void setCodigoTipoRefeicao(int codigoTipoRefeicao) {
		this.codigoTipoRefeicao = codigoTipoRefeicao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
	public double getCalorias() {
		return calorias;
	}
	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}
	public double getGramas() {
		return gramas;
	}
	public void setGramas(double gramas) {
		this.gramas = gramas;
	}

}
