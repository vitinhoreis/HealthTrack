package br.com.ig.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.ig.healthtrack.bean.Peso;
import br.com.ig.healthtrack.bean.Pressao;
import br.com.ig.healthtrack.dao.PressaoDAO;
import br.com.ig.healthtrack.exception.DBException;
import br.com.ig.healthtrack.singleton.ConnectionManager;


public class OraclePressaoDAO  implements PressaoDAO{
	
	private Connection conexao;
	
	@Override
	public void cadastrar(Pressao pressao) throws DBException {
		
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_PRESSAO (CD_USUARIO,"
					+ " SISTOLICA,"
					+ " DIASTOLICA,"
					+ " CLASSIFICACAO,"
					+ " DT_MEDICAO)"
					+ " VALUES (?, ?, ?, ?, ?)";
			
			java.sql.Date dataHora = new java.sql.Date(pressao.getDataHoraMedicao().getTimeInMillis());
			
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, pressao.getCodigoUsuario());
			stmt.setInt(2, pressao.getSistolica());
			stmt.setInt(3, pressao.getDiastolica());
			stmt.setString(4, pressao.getClassificacao());
			stmt.setDate(5, dataHora);
			
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
	public void atualizar(Pressao pressao) throws DBException {
		
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_PRESSAO SET SISTOLICA = ?,"
					+ " DIASTOLICA = ?,"
					+ " CLASSIFICACAO = ?,"
					+ " DT_MEDICAO = ?"
					+ " WHERE CD_PRESSAO = ?";
			
			stmt = conexao.prepareStatement(sql);
			
			java.sql.Date dataHora = new java.sql.Date(pressao.getDataHoraMedicao().getTimeInMillis());
			
			stmt.setDouble(1, pressao.getSistolica());
			stmt.setDouble(2, pressao.getDiastolica());
			stmt.setString(3, pressao.getClassificacao());
			stmt.setDate(4, dataHora);
			stmt.setInt(5, pressao.getCodigo());
			
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
			String sql = "DELETE FROM T_PRESSAO WHERE CD_PRESSAO = ?";
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
	public Pressao obter(int id) {
		
		Pressao pressao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
 			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_PRESAO WHERE CD_PRESAO = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()){
				int codigo = rs.getInt("CD_PRESSAO");
				int codigoUsuario = rs.getInt("CD_USUARIO");
				int sistolica = rs.getInt("SISTOLICA");
				int diastolica = rs.getInt("DIASTOLICA");
				String classificacao = rs.getString("CLASSIFICACAO");
				java.sql.Date dataHora = rs.getDate("DT_MEDICAO");
			
				Calendar dataHoraMedicao = Calendar.getInstance();
				dataHoraMedicao.setTimeInMillis(dataHora.getTime());
												
				pressao = new Pressao(codigo,
						codigoUsuario, 
						sistolica, 
						diastolica,
						classificacao,
						dataHoraMedicao);
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
		return pressao;
	}

	@Override
	public List<Pressao> listar(int codigoUsuario) {
		List<Pressao> lista = new ArrayList<Pressao>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_PRESSAO WHERE CD_USUARIO = ?");
			stmt.setInt(1, codigoUsuario);
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				int codigo = rs.getInt("CD_PRESSAO");
				int codUsuario = rs.getInt("CD_USUARIO");
				int sistolica = rs.getInt("SISTOLICA");
				int diastolica = rs.getInt("DIASTOLICA");
				String classificacao = rs.getString("CLASSIFICACAO");
				java.sql.Date dataHora = rs.getDate("DT_MEDICAO");
			
				Calendar dataHoraMedicao = Calendar.getInstance();
				dataHoraMedicao.setTimeInMillis(dataHora.getTime());
												
				Pressao pressao = new Pressao(codigo,
						codUsuario, 
						sistolica, 
						diastolica,
						classificacao,
						dataHoraMedicao);
				
				lista.add(pressao);
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


