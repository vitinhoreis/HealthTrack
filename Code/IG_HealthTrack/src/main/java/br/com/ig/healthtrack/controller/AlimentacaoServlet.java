package br.com.ig.healthtrack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ig.healthtrack.bean.Alimentacao;
import br.com.ig.healthtrack.bean.Usuario;
import br.com.ig.healthtrack.dao.AlimentacaoDAO;
import br.com.ig.healthtrack.exception.DBException;
import br.com.ig.healthtrack.factory.DAOFactory;

@WebServlet("/alimentacao")
public class AlimentacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AlimentacaoDAO dao;

    
	public AlimentacaoServlet() {
		 super();
		 dao = DAOFactory.getAlimentacaoDAO();
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
		Alimentacao al = new Alimentacao();
		int id = Integer.parseInt(request.getParameter("id"));
		al.setCodigo(id);
		try {
			dao.remover(id);
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao apagagar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("Alimentacao.jsp").forward(request, response);
	}

	private void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("name");
		String caloria = request.getParameter("caloria");
		String peso = request.getParameter("peso");
		String tipo = request.getParameter("tipo");	
		int id = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		int codigoUsuario = (int)session.getAttribute("codigoUsuario");
		
		Alimentacao alAtual = dao.obter(id);
		
		Alimentacao al = new Alimentacao();
		al.setCodigo(id);
		al.setCodigoUsuario(codigoUsuario);
		al.setDataHora(Calendar.getInstance());
		
		if(nome.isBlank()) {
			al.setDescricao(alAtual.getDescricao());
		}else {
			al.setDescricao(nome);	
		}
		if(peso.isBlank()) {
			al.setGramas(alAtual.getGramas());
		}else {
			al.setGramas(Double.parseDouble(peso));	
		}
		if(caloria.isBlank()) {
			al.setCalorias(alAtual.getCalorias());
		}else {
			al.setGramas(Double.parseDouble(caloria));	
		}
		if(tipo.isBlank()) {
			al.setCodigoTipoRefeicao(alAtual.getCodigoTipoRefeicao());
		}else {
			al.setCodigoTipoRefeicao(getTipo(tipo));	
		}
		
		try {
			dao.atualizar(al);
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("Alimentacao.jsp").forward(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Alimentacao al = dao.obter(id);
		request.setAttribute("id", id);
		request.setAttribute("al", al);
		request.getRequestDispatcher("/editarAlimentacao.jsp").forward(request, response);
	}
	


	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("name");
		double caloria = Double.parseDouble(request.getParameter("caloria"));
		double peso = Double.parseDouble(request.getParameter("peso"));
		String tipo = request.getParameter("tipo");
		
		HttpSession session = request.getSession();
		int codigoUsuario = (int)session.getAttribute("codigoUsuario");
		
		Alimentacao al = new Alimentacao();
		al.setDescricao(nome);
		al.setCodigoUsuario(codigoUsuario);
		al.setDataHora(Calendar.getInstance());
		al.setGramas(peso);
		al.setCalorias(caloria);
		al.setCodigoTipoRefeicao(getTipo(tipo));
		
		try {
			dao.cadastrar(al);
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		
		request.getRequestDispatcher("Alimentacao.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int codigoUsuario = (int)session.getAttribute("codigoUsuario");
		
//		int id = Integer.parseInt(request.getParameter("codigo"));
		System.out.println("nois");
		List<Alimentacao> al = dao.listar(codigoUsuario);
		request.setAttribute("alimentacao", al);
		
		request.getRequestDispatcher("historicoAlimentacao.jsp").forward(request, response);
	}
	
	private int getTipo(String tipo) {
		int tipoR = 0;
		if(tipo.equalsIgnoreCase("Café da manhã")) {
			tipoR = 1;
		}else if(tipo.equalsIgnoreCase("Brunch")) {
			tipoR = 2;
		}else if(tipo.equalsIgnoreCase("Almoço")) {
			tipoR = 3;
		}else if(tipo.equalsIgnoreCase("Lanche")) {
			tipoR = 4;
		}else if(tipo.equalsIgnoreCase("Jantar")) {
			tipoR = 5;
		}else if(tipo.equalsIgnoreCase("Sobremesa")) {
			tipoR = 6;
		}else if(tipo.equalsIgnoreCase("Ceia")) {
			tipoR = 7;
		}else if(tipo.equalsIgnoreCase("Pré-treino")) {
			tipoR = 8;
		}else if(tipo.equalsIgnoreCase("Pós-treino")) {
			tipoR = 9;
		}
		return tipoR;
	}
}
