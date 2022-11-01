package br.com.ig.healthtrack.dao;

import  br.com.ig.healthtrack.bean.Usuario;
import  br.com.ig.healthtrack.exception.DBException;

public interface UsuarioDAO {
	
	void cadastrar(Usuario usuario) throws DBException;
	void atualizar(Usuario usuario) throws DBException;
	void remover(int codigo) throws DBException;
	Usuario obter(int id);
	Usuario obterPorEmail(String email);
}
