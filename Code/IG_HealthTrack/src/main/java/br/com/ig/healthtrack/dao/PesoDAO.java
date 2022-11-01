package br.com.ig.healthtrack.dao;

import java.util.List;

import  br.com.ig.healthtrack.bean.Peso;
import  br.com.ig.healthtrack.exception.DBException;

public interface PesoDAO {
	
	void cadastrar(Peso peso) throws DBException;
	void atualizar(Peso peso) throws DBException;
	void remover(int codigo) throws DBException;
	Peso obter(int id);
	List<Peso> listar(int codigoUsuario);
}
