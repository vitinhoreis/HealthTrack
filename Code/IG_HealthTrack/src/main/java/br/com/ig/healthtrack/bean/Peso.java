package br.com.ig.healthtrack.bean;

import java.util.Calendar;

public class Peso {
	
	private int codigo;
	private int codigoUsuario;
	private double peso;
	private Calendar dataMedicao;
	
	public Peso(int codigo, int codigoUsuario, double peso, Calendar dataMedicao) {
		super();
		this.codigo = codigo;
		this.codigoUsuario = codigoUsuario;
		this.peso = peso;
		this.dataMedicao = dataMedicao;
	}
	
		
	public Peso() {
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
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Calendar getDataMedicao() {
		return dataMedicao;
	}
	public void setDataMedicao(Calendar dataMedicao) {
		this.dataMedicao = dataMedicao;
	}

}
