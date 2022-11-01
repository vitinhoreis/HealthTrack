package br.com.ig.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ig.healthtrack.bean.TipoAtividade;
import br.com.ig.healthtrack.bean.TipoRefeicao;
import br.com.ig.healthtrack.dao.TipoRefeicaoDAO;
import br.com.ig.healthtrack.singleton.ConnectionManager;

public class OracleTipoRefeicaoDAO  implements TipoRefeicaoDAO{
	
	private Connection conexao;
	
	@Override
	public List<TipoRefeicao> listar() {
		
		List<TipoRefeicao> lista = new ArrayList<TipoRefeicao>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_TIPO_REFEICAO  ORDER BY NM_TIPO_REFEICAO");
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				int codigo = rs.getInt("CD_TIPO");
				String nome = rs.getString("NM_TIPO_REFEICAO");
				String descricao = rs.getString("DS_TIPO_REFEICAO");
				TipoRefeicao refeicao = new TipoRefeicao(codigo,nome,descricao);
				lista.add(refeicao);
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


