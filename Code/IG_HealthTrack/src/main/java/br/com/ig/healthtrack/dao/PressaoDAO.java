package br.com.ig.healthtrack.dao;

import java.util.List;

import  br.com.ig.healthtrack.bean.Pressao;
import  br.com.ig.healthtrack.exception.DBException;

public interface PressaoDAO {
	
	void cadastrar(Pressao pressao) throws DBException;
	void atualizar(Pressao pressao) throws DBException;
	void remover(int codigo) throws DBException;
	Pressao obter(int id);
	List<Pressao> listar(int codigoUsuario);
}
