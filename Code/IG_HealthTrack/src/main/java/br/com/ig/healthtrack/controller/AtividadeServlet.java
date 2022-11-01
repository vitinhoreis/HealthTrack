package br.com.ig.healthtrack.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ig.healthtrack.bean.Alimentacao;
import br.com.ig.healthtrack.bean.Atividade;
import br.com.ig.healthtrack.bean.TipoAtividade;
import br.com.ig.healthtrack.dao.AtividadeDAO;
import br.com.ig.healthtrack.dao.TipoAtividadeDAO;
import br.com.ig.healthtrack.exception.DBException;
import br.com.ig.healthtrack.factory.DAOFactory;

@WebServlet("/atividade")
public class AtividadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AtividadeDAO dao;
	private TipoAtividadeDAO tipoDao;

	public AtividadeServlet() {
		 super();
		 dao = DAOFactory.getAtividadeDAO();
		 tipoDao = DAOFactory.getTipoAtividadeDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "editar":
			editar(request,response);
			break;
		case "atualizar":
			atualizar(request, response);
			break;
		case "apagar":
			apagar(request, response);
			break;
		}
	}
	
	private void apagar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			dao.remover(id);
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao apagagar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("Exercicio.jsp").forward(request, response);
	}
	
	private void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int codigoUsuario = (int)session.getAttribute("codigoUsuario");
		
		String descricao = request.getParameter("name");
		String quilometragem = request.getParameter("quilometragem");
		String dificuldade = request.getParameter("dificuldade");
		String tipo = request.getParameter("tipo");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Atividade atv = new Atividade();
		Atividade atvAtual = dao.obter(id);
		
		atv.setCodigoUsuario(codigoUsuario);
		atv.setDataHoraFim(Calendar.getInstance());
		atv.setDataHoraInicio(Calendar.getInstance());
		
		if(descricao.isBlank()) {
			atv.setDescricao(atvAtual.getDescricao());
		}else {
			atv.setDescricao(descricao);	
		}
		if(quilometragem.isBlank()) {
			atv.setQuilometragem(atvAtual.getQuilometragem());
		}else {
			atv.setQuilometragem(Double.parseDouble(quilometragem));	
		}
		if(dificuldade.isBlank()) {
			atv.setNivelDificuldade(atvAtual.getNivelDificuldade());
		}else {
			atv.setNivelDificuldade(getNivel(dificuldade));	
		}
		if(tipo.isBlank()) {
			atv.setCodigoTipoAtividade(atvAtual.getCodigoTipoAtividade());
		}else {
			atv.setCodigoTipoAtividade(getTipo(tipo));	
		}
		
		try {
			dao.atualizar(atv);
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("Exercicio.jsp").forward(request, response);
		
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int codigoUsuario = (int)session.getAttribute("codigoUsuario");
		
		String descricao = request.getParameter("name");
		Double quilometragem = Double.valueOf(request.getParameter("quilometragem"));
		String dificuldade = request.getParameter("dificuldade");
		String tipo = request.getParameter("tipo");
		
		Atividade atv = new Atividade();
		atv.setCodigoUsuario(codigoUsuario);
		atv.setDataHoraFim(Calendar.getInstance());
		atv.setDataHoraInicio(Calendar.getInstance());
		atv.setDescricao(descricao);
		atv.setQuilometragem(quilometragem);
		atv.setNivelDificuldade(getNivel(dificuldade));
		atv.setCodigoTipoAtividade(getTipo(tipo));
		
		try {
			dao.cadastrar(atv);
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("Exercicio.jsp").forward(request, response);
		
	}
	
	private int getTipo(String tipo) {
		int tp = 0;
		if(tipo.equalsIgnoreCase("Yoga")) {
			tp = 1;
		}else if(tipo.equalsIgnoreCase("Aeróbica")) {
			tp = 2;
		}else if(tipo.equalsIgnoreCase("Natação")) {
			tp = 3;
		}else if(tipo.equalsIgnoreCase("Corrida")) {
			tp = 4;
		}else if(tipo.equalsIgnoreCase("Caminhada")) {
			tp = 5;
		}else if(tipo.equalsIgnoreCase("Musculação")) {
			tp = 6;
		}else if(tipo.equalsIgnoreCase("Pedalada")) {
			tp = 7;
		}
		return tp;
	}

	private int getNivel(String dificuldade) {
		int nivel = 0;
		if(dificuldade.equalsIgnoreCase("Fácil")) {
			nivel = 1;
		}else if(dificuldade.equalsIgnoreCase("Moderado")) {
			nivel = 2;
		}else if(dificuldade.equalsIgnoreCase("Difícil")) {
			nivel = 3;
		}else if(dificuldade.equalsIgnoreCase("Muito difícil")) {
			nivel = 4;
		}
		return nivel;
	}

	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<TipoAtividade> tipoList = tipoDao.listar();
		request.setAttribute("tipoAtividade", tipoList);
		
		int id = Integer.parseInt(request.getParameter("id"));
		Atividade al = dao.obter(id);
		request.setAttribute("id", id);
		request.setAttribute("al", al);
		request.getRequestDispatcher("/editarAtividade.jsp").forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int codigoUsuario = (int)session.getAttribute("codigoUsuario");
		
		List<Atividade> atividade = dao.listar(codigoUsuario);

		
		request.setAttribute("atividade", atividade);


		request.getRequestDispatcher("historico-exercicio.jsp").forward(request, response);
	}
}
