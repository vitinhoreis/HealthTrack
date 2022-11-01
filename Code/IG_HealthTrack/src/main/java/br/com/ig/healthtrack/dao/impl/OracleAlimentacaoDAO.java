package br.com.ig.healthtrack.dao.impl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import br.com.ig.healthtrack.bean.Alimentacao;
import br.com.ig.healthtrack.dao.AlimentacaoDAO;
import br.com.ig.healthtrack.exception.DBException;
import br.com.ig.healthtrack.singleton.ConnectionManager;


public class OracleAlimentacaoDAO  implements AlimentacaoDAO{

	private Connection conexao;
	
	@Override
	public void cadastrar(Alimentacao alimentacao) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_ALIMENTACAO (cd_usuario,"
					+ " cd_tipo_refeicao,"
					+ " ds_alimentacao,"
					+ " dt_hora,"
					+ " nr_calorias,"
					+ " nr_peso)"
					+ " VALUES (?, ?, ?, ?, ?, ?)";
			
			java.sql.Date dataHoraRefeicao = new java.sql.Date(alimentacao.getDataHora().getTimeInMillis());
			
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, alimentacao.getCodigoUsuario());
			stmt.setInt(2, alimentacao.getCodigoTipoRefeicao());	
			stmt.setString(3, alimentacao.getDescricao());
			stmt.setDate(4, dataHoraRefeicao);
			stmt.setDouble(5, alimentacao.getCalorias());
			stmt.setDouble(6, alimentacao.getGramas());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void atualizar(Alimentacao alimentacao) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_ALIMENTACAO SET cd_tipo_refeicao = ?,"
					+ " ds_alimentacao = ?,"
					+ " dt_hora = ?,"
					+ " nr_calorias = ?,"
					+ " nr_peso = ?"
					+ " WHERE CD_ALIMENTACAO = ?";
			
			stmt = conexao.prepareStatement(sql);
			   		
		    java.sql.Date dataHoraRefeicao = new java.sql.Date(alimentacao.getDataHora().getTimeInMillis());
					
			stmt.setInt(1, alimentacao.getCodigoTipoRefeicao());	
			stmt.setString(2, alimentacao.getDescricao());
			stmt.setDate(3, dataHoraRefeicao);
			stmt.setDouble(4, alimentacao.getCalorias());
			stmt.setDouble(5, alimentacao.getGramas());
			stmt.setInt(6, alimentacao.getCodigo());	
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void remover(int codigo) throws DBException {
		
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_ALIMENTACAO WHERE CD_ALIMENTACAO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigo);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Alimentacao obter(int id) {
		Alimentacao alimentacao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
 			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_ALIMENTACAO WHERE CD_ALIMENTACAO = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()){
				int codigo = rs.getInt("CD_ALIMENTACAO");
				int codigoUsuario = rs.getInt("CD_USUARIO");
				int codigoTipoRefeicao = rs.getInt("CD_TIPO_REFEICAO");
				String nome = rs.getString("DS_ALIMENTACAO");
				java.sql.Date dataHora = rs.getDate("DT_HORA");
				double calorias = rs.getDouble("NR_CALORIAS");
				double gramas = rs.getDouble("NR_PESO");


				Calendar dataHoraRefeicao = Calendar.getInstance();
				dataHoraRefeicao.setTimeInMillis(dataHora.getTime());

				
				alimentacao = new Alimentacao(codigo,
						codigoUsuario, 
						codigoTipoRefeicao, 
						nome,
						dataHoraRefeicao, 
						calorias, 
						gramas);
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
		return alimentacao;
	}

	@Override
	public List<Alimentacao> listar(int codigoUsuario) {
		List<Alimentacao> lista = new ArrayList<Alimentacao>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_ALIMENTACAO WHERE CD_USUARIO = ?");
			stmt.setInt(1, codigoUsuario);
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				int codigo = rs.getInt("CD_ALIMENTACAO");
				int codigoUsua = rs.getInt("CD_USUARIO");
				int codigoTipoRefeicao = rs.getInt("CD_TIPO_REFEICAO");
				String nome = rs.getString("DS_ALIMENTACAO");
				java.sql.Date dataHora = rs.getDate("DT_HORA");
				double calorias = rs.getDouble("NR_CALORIAS");
				double gramas = rs.getDouble("NR_PESO");


				Calendar dataHoraRefeicao = Calendar.getInstance();
				dataHoraRefeicao.setTimeInMillis(dataHora.getTime());

				
				Alimentacao alimentacao = new Alimentacao(codigo,
						codigoUsua, 
						codigoTipoRefeicao, 
						nome,
						dataHoraRefeicao, 
						calorias, 
						gramas);
				
				
				lista.add(alimentacao);
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


