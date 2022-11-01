package br.com.ig.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.ig.healthtrack.bean.TipoAtividade;
import br.com.ig.healthtrack.dao.TipoAtividadeDAO;
import br.com.ig.healthtrack.singleton.ConnectionManager;

public class OracleTipoAtividadeDAO  implements TipoAtividadeDAO{

	private Connection conexao;

	@Override
	public List<TipoAtividade> listar() {
		List<TipoAtividade> lista = new ArrayList<TipoAtividade>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_TIPO_ATIVIDADE ORDER BY NM_TIPO");
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				int codigo = rs.getInt("CD_TIPO");
				String nome = rs.getString("NM_TIPO");
				String descricao = rs.getString("DS_TIPO_ATIVIDADE");
				TipoAtividade atividade = new TipoAtividade(codigo,nome,descricao);
				lista.add(atividade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
	
}


