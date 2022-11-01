package br.com.ig.healthtrack.dao;

import java.util.List;

import  br.com.ig.healthtrack.bean.Alimentacao;
import  br.com.ig.healthtrack.exception.DBException;

public interface AlimentacaoDAO {
	
	void cadastrar(Alimentacao alimentacao) throws DBException;
	void atualizar(Alimentacao alimentacao) throws DBException;
	void remover(int codigo) throws DBException;
	Alimentacao obter(int id);
	List<Alimentacao> listar(int codigoUsuario);
}
