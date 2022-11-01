package br.com.ig.healthtrack.teste;

import java.util.List;

import br.com.ig.healthtrack.bean.TipoAtividade;
import br.com.ig.healthtrack.dao.TipoAtividadeDAO;
import br.com.ig.healthtrack.factory.DAOFactory;

public class TipoAtividadeDAOTeste {

	public static void main(String[] args) {
		TipoAtividadeDAO dao = DAOFactory.getTipoAtividadeDAO();
		
		List<TipoAtividade> lista = dao.listar();
		for (TipoAtividade atividade : lista) {
			System.out.println(atividade.getCodigo() + " " + atividade.getNome());
		}
	}

}