package br.com.ig.healthtrack.bean;

import java.util.Calendar;

public class Atividade {
	
	private int codigo;
	private int codigoUsuario;
	private int codigoTipoAtividade;
	private Calendar dataHoraInicio;
	private Calendar dataHoraFim;
	private double quilometragem;
	private int nivelDificuldade;
	private String descricao;
	
	public Atividade(int codigo, int codigoUsuario, int codigoTipoAtividade, Calendar dataHoraInicio,
			Calendar dataHoraFim, double quilometragem, int nivelDificuldade, String descricao) {
		super();
		this.codigo = codigo;
		this.codigoUsuario = codigoUsuario;
		this.codigoTipoAtividade = codigoTipoAtividade;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		this.quilometragem = quilometragem;
		this.nivelDificuldade = nivelDificuldade;
		this.descricao = descricao;
	}
	
		
	public Atividade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	public int getCodigoTipoAtividade() {
		return codigoTipoAtividade;
	}
	public void setCodigoTipoAtividade(int codigoTipoAtividade) {
		this.codigoTipoAtividade = codigoTipoAtividade;
	}
	public Calendar getDataHoraInicio() {
		return dataHoraInicio;
	}
	public void setDataHoraInicio(Calendar dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}
	public Calendar getDataHoraFim() {
		return dataHoraFim;
	}
	public void setDataHoraFim(Calendar dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}
	public double getQuilometragem() {
		return quilometragem;
	}
	public void setQuilometragem(double quilometragem) {
		this.quilometragem = quilometragem;
	}
	public int getNivelDificuldade() {
		return nivelDificuldade;
	}
	public void setNivelDificuldade(int nivelDificuldade) {
		this.nivelDificuldade = nivelDificuldade;
	}
	
}
