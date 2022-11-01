package br.com.ig.healthtrack.teste;

import java.util.List;

import br.com.ig.healthtrack.bean.TipoRefeicao;
import br.com.ig.healthtrack.dao.TipoRefeicaoDAO;
import br.com.ig.healthtrack.factory.DAOFactory;

public class TipoRefeicaoDAOTeste {

	public static void main(String[] args) {
		TipoRefeicaoDAO dao = DAOFactory.getTipoRefeicaoDAO();
		
		List<TipoRefeicao> lista = dao.listar();
		for (TipoRefeicao refeicao : lista) {
			System.out.println(refeicao.getCodigo() + " " + refeicao.getNome());
		}
	}

}