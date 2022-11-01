package br.com.ig.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.ig.healthtrack.bean.Atividade;
import br.com.ig.healthtrack.bean.Peso;
import br.com.ig.healthtrack.dao.PesoDAO;
import br.com.ig.healthtrack.exception.DBException;
import br.com.ig.healthtrack.singleton.ConnectionManager;


public class OraclePesoDAO  implements PesoDAO{
	private Connection conexao;
	@Override
	public void cadastrar(Peso peso) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_PESO (CD_USUARIO,"
					+ " NR_PESO,"
					+ " DT_MEDICAO)"
					+ " VALUES (?, ?, ?)";
			
			java.sql.Date dataHora = new java.sql.Date(peso.getDataMedicao().getTimeInMillis());
			
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, peso.getCodigoUsuario());
			stmt.setDouble(2, peso.getPeso());
			stmt.setDate(3, dataHora);
			
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
	public void atualizar(Peso peso) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_PESO SET NR_PESO = ?,"
					+ " DT_MEDICAO = ?"
					+ " WHERE CD_PESO = ?";
			
			stmt = conexao.prepareStatement(sql);
			
			java.sql.Date dataHora = new java.sql.Date(peso.getDataMedicao().getTimeInMillis());
			
			stmt.setDouble(1, peso.getPeso());
			stmt.setDate(2, dataHora);
			stmt.setInt(3, peso.getCodigo());
			
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
			String sql = "DELETE FROM T_PESO WHERE CD_PESO = ?";
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
	public Peso obter(int id) {
		Peso peso = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
 			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_PESO WHERE CD_PESO = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()){
				int codigo = rs.getInt("CD_PESO");
				int codigoUsuario = rs.getInt("CD_USUARIO");
				double gramas = rs.getDouble("NR_PESO");
				java.sql.Date dataHora = rs.getDate("DT_MEDICAO");
			
				Calendar dataHoraMedicao = Calendar.getInstance();
				dataHoraMedicao.setTimeInMillis(dataHora.getTime());
												
				peso = new Peso(codigo,
						codigoUsuario, 
						gramas, 
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
		return peso;
	}

	@Override
	public List<Peso> listar(int codigoUsuario) {
		List<Peso> lista = new ArrayList<Peso>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_PESO WHERE CD_USUARIO = ?");
			stmt.setInt(1, codigoUsuario);
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				int codigo = rs.getInt("CD_PESO");
				int codUsuario = rs.getInt("CD_USUARIO");
				double gramas = rs.getDouble("NR_PESO");
				java.sql.Date dataHora = rs.getDate("DT_MEDICAO");
			
				Calendar dataHoraMedicao = Calendar.getInstance();
				dataHoraMedicao.setTimeInMillis(dataHora.getTime());
												
				Peso peso = new Peso(codigo,
						codUsuario, 
						gramas, 
						dataHoraMedicao);
				
				lista.add(peso);
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


