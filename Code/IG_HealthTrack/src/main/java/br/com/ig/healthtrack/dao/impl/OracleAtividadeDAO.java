package br.com.ig.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.ig.healthtrack.bean.Alimentacao;
import br.com.ig.healthtrack.bean.Atividade;
import br.com.ig.healthtrack.dao.AtividadeDAO;
import br.com.ig.healthtrack.exception.DBException;
import br.com.ig.healthtrack.singleton.ConnectionManager;


public class OracleAtividadeDAO  implements AtividadeDAO{
	private Connection conexao;
	@Override
	public void cadastrar(Atividade atividade) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_ATIVIDADE (CD_USUARIO,"
					+ " CD_TIPO_ATIVIDADE,"
					+ " DT_HORA_INICIO,"
					+ " DT_HORA_FIM,"
					+ " NR_QUILOMETRAGEM,"
					+ " NV_DIFICULDADE,"
					+ " DESCRICAO)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			java.sql.Date dataHoraInicio = new java.sql.Date(atividade.getDataHoraInicio().getTimeInMillis());
			java.sql.Date dataHoraFim = new java.sql.Date(atividade.getDataHoraFim().getTimeInMillis());
			
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, atividade.getCodigoUsuario());
			stmt.setInt(2, atividade.getCodigoTipoAtividade());	
			stmt.setDate(3, dataHoraInicio);
			stmt.setDate(4, dataHoraFim);
			stmt.setDouble(5, atividade.getQuilometragem());
			stmt.setInt(6, atividade.getNivelDificuldade());
			stmt.setString(7, atividade.getDescricao());
			
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
	public void atualizar(Atividade atividade) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_ATIVIDADE SET CD_TIPO_ATIVIDADE = ?,"
					+ " DT_HORA_INICIO = ?,"
					+ " DT_HORA_FIM = ?,"
					+ " NR_QUILOMETRAGEM = ?,"
					+ " NV_DIFICULDADE = ?,"
					+ " DESCRICAO = ?"
					+ " WHERE CD_ATIVIDADE = ?";
			
			stmt = conexao.prepareStatement(sql);
			   		
			java.sql.Date dataHoraInicio = new java.sql.Date(atividade.getDataHoraInicio().getTimeInMillis());
			java.sql.Date dataHoraFim = new java.sql.Date(atividade.getDataHoraFim().getTimeInMillis());
			
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, atividade.getCodigoTipoAtividade());	
			stmt.setDate(2, dataHoraInicio);
			stmt.setDate(3, dataHoraFim);
			stmt.setDouble(4, atividade.getQuilometragem());
			stmt.setInt(5, atividade.getNivelDificuldade());
			stmt.setString(6, atividade.getDescricao());
			stmt.setInt(7, atividade.getCodigo());	
			
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
			String sql = "DELETE FROM T_ATIVIDADE WHERE CD_ATIVIDADE = ?";
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
	public Atividade obter(int id) {
		Atividade atividade = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
 			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_ATIVIDADE WHERE CD_ATIVIDADE = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()){
				int codigo = rs.getInt("CD_ATIVIDADE");
				int codigoUsuario = rs.getInt("CD_USUARIO");
				int codigoTipoRefeicao = rs.getInt("CD_TIPO_ATIVIDADE");
				java.sql.Date dataHoraI = rs.getDate("DT_HORA_INICIO");
				java.sql.Date dataHoraF = rs.getDate("DT_HORA_FIM");
				String nome = rs.getString("DESCRICAO");
				double quilometragem = rs.getDouble("NR_QUILOMETRAGEM");
				int nivelDificuldade = rs.getInt("NV_DIFICULDADE");

				Calendar dataHoraInicio = Calendar.getInstance();
				dataHoraInicio.setTimeInMillis(dataHoraI.getTime());
				
				Calendar dataHoraFim = Calendar.getInstance();
				dataHoraFim.setTimeInMillis(dataHoraF.getTime());
				
				atividade = new Atividade(codigo,
						codigoUsuario, 
						codigoTipoRefeicao, 
						dataHoraInicio,
						dataHoraFim, 
						quilometragem, 
						nivelDificuldade,
						nome);
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
		return atividade;
	}

	@Override
	public List<Atividade> listar(int codigoUsuario) {
		
		List<Atividade> lista = new ArrayList<Atividade>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_ATIVIDADE WHERE CD_USUARIO = ?");
			stmt.setInt(1, codigoUsuario);
			rs = stmt.executeQuery();

			//Percorre todos os registros encontrados
			while (rs.next()) {
				int codigo = rs.getInt("CD_ATIVIDADE");
				int codUsuario = rs.getInt("CD_USUARIO");
				int codigoTipoRefeicao = rs.getInt("CD_TIPO_ATIVIDADE");
				java.sql.Date dataHoraI = rs.getDate("DT_HORA_INICIO");
				java.sql.Date dataHoraF = rs.getDate("DT_HORA_FIM");
				String nome = rs.getString("DESCRICAO");
				double quilometragem = rs.getDouble("NR_QUILOMETRAGEM");
				int nivelDificuldade = rs.getInt("NV_DIFICULDADE");

				Calendar dataHoraInicio = Calendar.getInstance();
				dataHoraInicio.setTimeInMillis(dataHoraI.getTime());
				
				Calendar dataHoraFim = Calendar.getInstance();
				dataHoraFim.setTimeInMillis(dataHoraF.getTime());
				
				Atividade atividade = new Atividade(codigo,
						codUsuario, 
						codigoTipoRefeicao, 
						dataHoraInicio,
						dataHoraFim, 
						quilometragem, 
						nivelDificuldade,
						nome);
				
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


