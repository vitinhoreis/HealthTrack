package br.com.ig.healthtrack.teste;

import br.com.ig.healthtrack.bean.Usuario;
import br.com.ig.healthtrack.dao.UsuarioDAO;
import br.com.ig.healthtrack.factory.DAOFactory;

public class UsuarioDAOTeste {
	
	public static void main(String[] args) {
	UsuarioDAO dao = DAOFactory.getUsuarioDAO();
	
	Usuario usuario = dao.obterPorEmail("paulocesarurbano@gmail.com");
	
	System.out.println("Nome : " + usuario.getNome() +", Senha: " +usuario.getSenha());
	
	}

}
