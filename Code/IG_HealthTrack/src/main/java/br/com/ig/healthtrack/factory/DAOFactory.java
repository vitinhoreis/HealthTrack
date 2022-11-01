package br.com.ig.healthtrack.factory;

import br.com.ig.healthtrack.dao.AlimentacaoDAO;
import br.com.ig.healthtrack.dao.AtividadeDAO;
import br.com.ig.healthtrack.dao.PesoDAO;
import br.com.ig.healthtrack.dao.PressaoDAO;
import br.com.ig.healthtrack.dao.TipoAtividadeDAO;
import br.com.ig.healthtrack.dao.TipoRefeicaoDAO;
import br.com.ig.healthtrack.dao.UsuarioDAO;
import br.com.ig.healthtrack.dao.impl.OracleAlimentacaoDAO;
import br.com.ig.healthtrack.dao.impl.OracleAtividadeDAO;
import br.com.ig.healthtrack.dao.impl.OraclePesoDAO;
import br.com.ig.healthtrack.dao.impl.OraclePressaoDAO;
import br.com.ig.healthtrack.dao.impl.OracleTipoAtividadeDAO;
import br.com.ig.healthtrack.dao.impl.OracleTipoRefeicaoDAO;
import br.com.ig.healthtrack.dao.impl.OracleUsuarioDAO;

public class DAOFactory {

	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
	
	public static AlimentacaoDAO getAlimentacaoDAO() {
		return new OracleAlimentacaoDAO();
	}
	
	public static AtividadeDAO getAtividadeDAO() {
		return new OracleAtividadeDAO();
	}
	
	public static PesoDAO getPesoDAO() {
		return new OraclePesoDAO();
	}
	
	public static PressaoDAO getPressaoDAO() {
		return new OraclePressaoDAO();
	}
	
	public static TipoAtividadeDAO getTipoAtividadeDAO(){
		return new OracleTipoAtividadeDAO();
	}
	
	public static TipoRefeicaoDAO getTipoRefeicaoDAO() {
		return new OracleTipoRefeicaoDAO();
	}
}
