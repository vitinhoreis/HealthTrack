package br.com.ig.healthtrack.dao.impl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import br.com.ig.healthtrack.bean.Usuario;
import br.com.ig.healthtrack.dao.UsuarioDAO;
import br.com.ig.healthtrack.exception.DBException;
import br.com.ig.healthtrack.singleton.ConnectionManager;


public class OracleUsuarioDAO  implements UsuarioDAO{

	private Connection conexao;
	
	@Override
	public void cadastrar(Usuario usuario) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_USUARIO (nm_usuario,"
					+ " ds_apelido,"
					+ " ft_foto,"
					+ " nr_altura,"
					+ " nr_cpf,"
					+ " dt_cadastro,"
					+ " dt_nascimento,"
					+ " ed_email,"
					+ " ds_senha,"
					+ " nr_telefone,"
					+ " sexo) "
					+ "VALUES (?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ?)";
			
			java.sql.Date dataNascimento = new java.sql.Date(usuario.getDataNascimento().getTimeInMillis());
			
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getApelido());
			stmt.setBlob(3, usuario.getFoto());
			stmt.setInt(4, usuario.getAltura());
			stmt.setString(5, usuario.getCpf());
			stmt.setDate(6, dataNascimento);
			stmt.setString(7, usuario.getEmail());
			stmt.setString(8, usuario.getSenha());
			stmt.setString(9, usuario.getCelular());
			stmt.setInt(10, usuario.getSexo());
			
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
	public void atualizar(Usuario usuario) throws DBException {
		
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_USUARIO SET nm_usuario = ?,"
					+ " ds_apelido = ?,"
					+ " ft_foto = ?,"
					+ " nr_altura = ?,"
					+ " nr_cpf = ?,"
					+ " dt_nascimento = ?,"
					+ " ed_email = ?,"
					+ " ds_senha = ?,"
					+ " nr_telefone = ?,"
					+ " sexo = ?"
					+ " WHERE CD_USUARIO = ?";
			
		    java.sql.Date dataNascimento = new java.sql.Date(usuario.getDataNascimento().getTimeInMillis());
			
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getApelido());
			stmt.setBlob(3, usuario.getFoto());
			stmt.setInt(4, usuario.getAltura());
			stmt.setString(5, usuario.getCpf());
			stmt.setDate(6, dataNascimento);
			stmt.setString(7, usuario.getEmail());
			stmt.setString(8, usuario.getSenha());
			stmt.setString(9, usuario.getCelular());
			stmt.setInt(10, usuario.getSexo());
			stmt.setInt(11, usuario.getCodigo());
			
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
			String sql = "DELETE FROM T_USUARIO WHERE CD_USUARIO = ?";
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
	public Usuario obter(int id) {
		
		Usuario usuario = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
 			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_USUARIO WHERE CD_USUARIO = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()){
				int codigo = rs.getInt("CD_USUARIO");
				String nome = rs.getString("NM_USUARIO");
				String apelido = rs.getString("DS_APELIDO");
				Blob foto = rs.getBlob("FT_FOTO");
				int altura = rs.getInt("NR_ALTURA");
				String cpf = rs.getString("NR_CPF");
				java.sql.Date dataCadastro = rs.getDate("DT_CADASTRO");
				java.sql.Date dataNascimento = rs.getDate("DT_NASCIMENTO");
				String email = rs.getString("ED_EMAIL");
				String senha = rs.getString("DS_SENHA");
				String celular = rs.getString("NR_TELEFONE");
				int sexo = rs.getInt("SEXO");


				Calendar dataCadastroC = Calendar.getInstance();
				dataCadastroC.setTimeInMillis(dataCadastro.getTime());
				
				Calendar dataNascimentoC = Calendar.getInstance();
				dataNascimentoC.setTimeInMillis(dataNascimento.getTime());
				
				usuario = new Usuario(codigo,
						nome, 
						apelido, 
						foto,
						altura, 
						cpf, 
						dataCadastroC,
						dataNascimentoC,
						email,
						senha, 
						celular,
						sexo);
				
				usuario.setSenhaCriptografada(senha);
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
		return usuario;
	}

	@Override
	public Usuario obterPorEmail(String email) {
		Usuario usuario = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
 			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_USUARIO WHERE ED_EMAIL = ?");
			stmt.setString(1, email);
			rs = stmt.executeQuery();

			if (rs.next()){
				int codigo = rs.getInt("CD_USUARIO");
				String nome = rs.getString("NM_USUARIO");
				String apelido = rs.getString("DS_APELIDO");
				Blob foto = rs.getBlob("FT_FOTO");
				int altura = rs.getInt("NR_ALTURA");
				String cpf = rs.getString("NR_CPF");
				java.sql.Date dataCadastro = rs.getDate("DT_CADASTRO");
				java.sql.Date dataNascimento = rs.getDate("DT_NASCIMENTO");
				String mail = rs.getString("ED_EMAIL");
				String senha = rs.getString("DS_SENHA");
				String celular = rs.getString("NR_TELEFONE");
				int sexo = rs.getInt("SEXO");


				Calendar dataCadastroC = Calendar.getInstance();
				dataCadastroC.setTimeInMillis(dataCadastro.getTime());
				
				Calendar dataNascimentoC = Calendar.getInstance();
				dataNascimentoC.setTimeInMillis(dataNascimento.getTime());
				
				usuario = new Usuario(codigo,
						nome, 
						apelido, 
						foto,
						altura, 
						cpf, 
						dataCadastroC,
						dataNascimentoC,
						mail,
						senha, 
						celular,
						sexo);
				
				usuario.setSenhaCriptografada(senha);
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
		return usuario;
	}
}


