package br.com.ig.healthtrack.dao;

import java.util.List;

import  br.com.ig.healthtrack.bean.Atividade;
import  br.com.ig.healthtrack.exception.DBException;

public interface AtividadeDAO {
	
	void cadastrar(Atividade atividade) throws DBException;
	void atualizar(Atividade atividade) throws DBException;
	void remover(int codigo) throws DBException;
	Atividade obter(int id);
	List<Atividade> listar(int codigoUsuario);
}
