package br.com.ig.healthtrack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ig.healthtrack.bean.Pressao;
import br.com.ig.healthtrack.dao.PressaoDAO;
import br.com.ig.healthtrack.exception.DBException;
import br.com.ig.healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class PressaoServlet
 */
@WebServlet("/pressao")
public class PressaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PressaoDAO dao;
       
    public PressaoServlet() {
    	super();
		 dao = DAOFactory.getPressaoDAO();
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
		}
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			int codigoUsuario = Integer.parseInt(request.getParameter("v"));
			int sistolica = Integer.parseInt(request.getParameter("sistolica"));
			int diastolica = Integer.parseInt(request.getParameter("diastolica"));
			String classificacao = request.getParameter("classificacao");
			
	     	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataHoraMedicao = Calendar.getInstance();
			dataHoraMedicao.setTime(format.parse(request.getParameter("dataHoraMedicao")));
			
			
			Pressao pressao = new Pressao(codigo,
					codigoUsuario,
					sistolica,
					diastolica,
					classificacao,
					dataHoraMedicao); 
			
			dao.atualizar(pressao);
			
			request.setAttribute("msg", "Registro atualizado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("Peso.jsp").forward(request, response);
	}
	


	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			int sistolica = Integer.parseInt(request.getParameter("sistolica"));
			int diastolica = Integer.parseInt(request.getParameter("diastolica"));
			String classificacao = request.getParameter("classificacao");
			int codigoUsuario = Integer.parseInt(request.getParameter("codigoUsuario"));
						
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataHoraMedicao = Calendar.getInstance();
			dataHoraMedicao.setTime(format.parse(request.getParameter("dataHoraMedicao")));
			
			Pressao pressao = new Pressao(0,
					codigoUsuario,
					sistolica,
					diastolica,
					classificacao,
					dataHoraMedicao); 
			
			dao.cadastrar(pressao);
			
			request.setAttribute("msg", "Pressão Arterial registrada!");
			
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao registrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-pressao.jsp").forward(request, response);
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		Pressao pressao = dao.obter(id);
		request.setAttribute("pressao", pressao);
		request.getRequestDispatcher("edicao-pressao.jsp").forward(request, response);
	}

}
