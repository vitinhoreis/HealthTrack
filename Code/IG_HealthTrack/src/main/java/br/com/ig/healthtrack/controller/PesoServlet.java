package br.com.ig.healthtrack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ig.healthtrack.bean.Peso;
import br.com.ig.healthtrack.dao.PesoDAO;
import br.com.ig.healthtrack.exception.DBException;
import br.com.ig.healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class PesoServlet
 */
@WebServlet("/peso")
public class PesoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PesoDAO dao;

    
	public PesoServlet() {
		 super();
		 dao = DAOFactory.getPesoDAO();
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
			
			HttpSession session = request.getSession();
			int codigoUsuario = (int)session.getAttribute("codigoUsuario");
			
			double gramas = Double.parseDouble(request.getParameter("peso"));

	     	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataMedicao = Calendar.getInstance();
			dataMedicao.setTime(format.parse(request.getParameter("dataHoraMedicao")));
			
			Peso peso = new Peso(codigo,
					codigoUsuario,
					gramas,
					dataMedicao); 
			
			dao.atualizar(peso);
			
			request.setAttribute("msg", "Peso atualizado!");
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
			//int codigoUsuario = Integer.parseInt(request.getParameter("codigoUsuario"));
			
			HttpSession session = request.getSession();
			int codigoUsuario = (int)session.getAttribute("codigoUsuario");
			
			
			double gramas = Double.parseDouble(request.getParameter("peso"));

	     	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataMedicao = Calendar.getInstance();
			dataMedicao.setTime(format.parse(request.getParameter("dataHoraMedicao")));
			
			Peso peso = new Peso(
					0,
					codigoUsuario,
					gramas,
					dataMedicao); 
			
			dao.cadastrar(peso);
			
			request.setAttribute("msg", "Peso cadastrado!");
			
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("Peso.jsp").forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("codigo"));
		Peso peso = dao.obter(id);
		request.setAttribute("peso", peso);
		
		request.getRequestDispatcher("edicao-peso.jsp").forward(request, response);
	}
}
